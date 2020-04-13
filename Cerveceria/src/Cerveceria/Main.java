package Cerveceria;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        BeerHouse cervecin = new BeerHouse(new Random());
        BeerProducer beerProducer = new BeerProducer(cervecin);
        BeerConsumer beerConsumer = new BeerConsumer(cervecin);
        Thread productor = new Thread(beerProducer);
        Thread consumidor = new Thread(beerConsumer);
        productor.start();
        consumidor.start();
    }
}
