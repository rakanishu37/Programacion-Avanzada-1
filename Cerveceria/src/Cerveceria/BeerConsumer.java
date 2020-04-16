package Cerveceria;

import java.util.Random;

public class BeerConsumer implements Runnable{
    private BeerHouse inventory;
    private boolean abierto = true;
    public BeerConsumer(BeerHouse inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        Random beersBought = new Random();
        while(abierto){
            try{
                inventory.consumeBeer(beersBought.nextInt(10)+1);
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                this.abierto = false;
            }
        }
    }
}
