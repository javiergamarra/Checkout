package com.nhpatt.checkout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void oneAppleAndTwoCherriesShouldSum230() {
		Checkout checkout = new Checkout();
		checkout.scan("Apples");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(175, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(230, checkout.getTotal());
	}

	@Test
	public void oneAppleAndOneCherryAndOneBananaShouldSum325() {
		Checkout checkout = new Checkout();
		checkout.scan("Apples");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(175, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(325, checkout.getTotal());
	}

	@Test
	public void twoCherriesShouldSum130() {
		Checkout checkout = new Checkout();
		checkout.scan("Cherries");
		assertEquals(75, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(130, checkout.getTotal());
	}

	@Test
	public void twoCherriesAndTwoBananasShouldSum280() {
		Checkout checkout = new Checkout();
		checkout.scan("Cherries");
		assertEquals(75, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(130, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(280, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(280, checkout.getTotal());
	}

	@Test
	public void mixedFruitShouldSum280() {
		Checkout checkout = new Checkout();
		checkout.scan("Cherries");
		assertEquals(75, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(175, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(230, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(380, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(180, checkout.getTotal());
		checkout.scan("Apples");
		assertEquals(280, checkout.getTotal());
	}

	@Test
	public void mixedFruitShouldSum430() {
		Checkout checkout = new Checkout();
		checkout.scan("Mele");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(200, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(300, checkout.getTotal());
		checkout.scan("Apples");
		assertEquals(300, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Mele");
		assertEquals(150, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(225, checkout.getTotal());
		checkout.scan("Cherries");
		assertEquals(280, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(430, checkout.getTotal());
	}

	@Test
	public void mixedFruitShouldSum200() {
		Checkout checkout = new Checkout();
		checkout.scan("Mele");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(200, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(300, checkout.getTotal());
		checkout.scan("Mele");
		assertEquals(250, checkout.getTotal());
		checkout.scan("Bananas");
		assertEquals(200, checkout.getTotal());
	}

	@Test
	public void mixedFruitShouldSum150() {
		Checkout checkout = new Checkout();
		checkout.scan("Mele");
		assertEquals(100, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(200, checkout.getTotal());
		checkout.scan("Pommes");
		assertEquals(300, checkout.getTotal());
		checkout.scan("Apples");
		assertEquals(300, checkout.getTotal());
		checkout.scan("Mele");
		assertEquals(150, checkout.getTotal());
	}

}
