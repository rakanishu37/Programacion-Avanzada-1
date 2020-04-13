package Cerveceria;

public class BeerProducer implements Runnable{
    private BeerHouse inventory;

    public BeerProducer(BeerHouse inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        System.out.println("Inicia la produccion");
        while (true){
            inventory.produceBeer();
        }
    }
}
