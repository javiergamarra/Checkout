package com.nhpatt.checkout;

import java.util.Scanner;

public class Checkout {

	public static void main(String[] args) {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			String[] linea = scanner.nextLine().split(",");
			for (String cadena : linea) {
				supermarket.scan(cadena.trim());
			}
			System.out.println(supermarket.getTotal());
		}

	}
}
