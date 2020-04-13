package Cerveceria;

import java.util.Random;

public class BeerHouse {
	private final int MAX_STOCK = 100;
	private boolean available = false;
	private int stock = 0;

	public synchronized void produceBeer() {
		Random producedBeers = new Random();
		int quantity = producedBeers.nextInt(25) + 1;

		while (available) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		available = true;

		if ((this.stock + quantity) < this.MAX_STOCK) {
		    this.stock = this.stock + quantity;
			System.out.println(quantity + " beers have been produced");
			System.out.println("Stock has: " + this.stock + " beers");
		} else {
			System.out.println("Stock is full, it has " + this.stock + " beers");
		}
		this.notify();
	}

	public synchronized void consumeBeer(int quantityDrank) throws IllegalStateException {
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
