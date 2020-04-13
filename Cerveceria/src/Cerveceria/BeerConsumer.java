package Cerveceria;

import java.util.Random;

public class BeerConsumer implements Runnable{
    private BeerHouse inventory;

    public BeerConsumer(BeerHouse inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        Random beersBought = new Random();
        while(true){
            try{
                inventory.consumeBeer(beersBought.nextInt(10)+1);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
