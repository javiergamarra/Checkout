package com.nhpatt.checkout;

import java.util.Scanner;

public class FrescoCheckout {

	public static void main(String[] args) {
		Checkout checkout = new Checkout();
		for (;;) {
			Scanner scan = new Scanner(System.in);
			for (String character : scan.nextLine().split(",")) {
				checkout.scan(character.trim());
				System.out.println(checkout.getTotal());
			}
		}
	}
}
