package Cerveceria;

import java.util.Random;

public class BeerHouse {
	private final int MAX_STOCK = 100;
	private boolean available = false;
	private int stock = 0;
	Random producingCapacityBeers;

	public BeerHouse(Random producingCapacityBeers) {
		this.producingCapacityBeers = producingCapacityBeers;
	}

	public synchronized void produceBeer() {
		int quantity = producingCapacityBeers.nextInt(25) + 1;
		int newStock = 0;
		//while (this.stock == 100) {
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
			System.out.println("Stock has: " + this.stock + " beers");
		} else {
			this.stock = this.MAX_STOCK;
			System.out.println(newStock - this.MAX_STOCK + " beers have been produced");
			System.out.println("Stock is now full, it has " + this.stock + " beers");
		}
		this.notify();
	}

	public synchronized void consumeBeer(int quantityDrank) throws IllegalStateException {
		//while (this.stock == 0) {
		while (!available) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		available = false;

		if(quantityDrank > stock){
		    quantityDrank = stock;
		    this.stock = 0;
        }
		else{
            this.stock = this.stock - quantityDrank;
        }

		System.out.println(quantityDrank + " beers has drank.");
        if(this.stock == 0){
            available = true;
            throw new IllegalStateException("No hay mas cervezas");
        }
		System.out.println("Stock has: " + this.stock + " beers.");
		this.notify();
	}
}
