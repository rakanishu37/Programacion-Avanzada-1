package Cerveceria;

import java.util.Random;

public class BeerHouse {
    private final int MAX_STOCK = 100;
    private boolean available = false;
    private boolean outOfMaterials = false;
    private int stock = 0;
    Random producingCapacityBeers;

    public BeerHouse(Random producingCapacityBeers) {
        this.producingCapacityBeers = producingCapacityBeers;
    }

    public synchronized void produceBeer() throws Throwable {
        int quantity = producingCapacityBeers.nextInt(25) + 1;
        int newStock = 0;

        while (available) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;

        newStock = (this.stock + quantity);
        if (newStock <= this.MAX_STOCK) {
            this.stock = newStock;
            System.out.println(quantity + " beers have been produced");
            System.out.println(String.format("Stock has: %s beers", this.stock ));
        } else {
            this.stock = this.MAX_STOCK;
            System.out.println(newStock - this.MAX_STOCK + " beers have been produced");
			System.out.println(String.format("Stock is now full, it has %s beers", this.stock ));
            outOfMaterials = true;
        }
        this.notify();
        if(outOfMaterials){
            throw new Throwable("No hay mas materiales para producir");
        }
    }

    public synchronized void consumeBeer(int quantityDrank) throws Throwable {
        while (!available) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(quantityDrank > stock){
            quantityDrank = stock;
            this.stock = 0;
        }
        else{
            this.stock = this.stock - quantityDrank;
        }

        System.out.println(quantityDrank + " beers has drank.");
        if(this.stock == 0 && outOfMaterials){
            throw new Throwable("No hay mas cervezas");
        }
        System.out.println(String.format("Stock has: %s beers", this.stock ));
        if(!outOfMaterials){
            available = false;
            this.notify();
        }
    }
}