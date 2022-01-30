package program;

import modal.entities.Cliente;
import modal.entities.Product;

public class Application {
	public static void main(String[] args) {
		Product prod = new Product("suco", 5, 1.50);
		Product prod1 = new Product("Coca-cola", 2, 9.50);
		prod.inserir();
		prod1.inserir();
		
		Cliente cl = new Cliente("Adrian", "adrian@gmail.com");
		Cliente cl1 = new Cliente("Guilherme", "guilherme@gmail.com");
		cl.inserir();
		cl1.inserir();
	}

}
