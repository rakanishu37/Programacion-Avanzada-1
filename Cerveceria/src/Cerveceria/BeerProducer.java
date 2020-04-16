package Cerveceria;

public class BeerProducer implements Runnable{
    private BeerHouse inventory;
    private boolean produce = true;
    public BeerProducer(BeerHouse inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        System.out.println("Inicia la produccion");
        while (this.produce){
            try{
                inventory.produceBeer();
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                this.produce =  false;
            }
        }
    }
}
