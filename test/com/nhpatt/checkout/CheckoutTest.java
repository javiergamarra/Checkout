package com.nhpatt.checkout;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhpatt.checkout.SuperMarketCheckout;

public class CheckoutTest {

	@Test
	public void oneAppleAndTwoCherriesShouldSum250() {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		supermarket.scan("Apples");
		assertEquals(100, supermarket.getTotal());
		supermarket.scan("Cherries");
		assertEquals(175, supermarket.getTotal());
		supermarket.scan("Cherries");
		assertEquals(230, supermarket.getTotal());
	}

	@Test
	public void twoCherriesAndTwoBananasShouldSum270() {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		supermarket.scan("Cherries");
		assertEquals(75, supermarket.getTotal());
		supermarket.scan("Cherries");
		assertEquals(130, supermarket.getTotal());
		supermarket.scan("Bananas");
		assertEquals(280, supermarket.getTotal());
		supermarket.scan("Bananas");
		assertEquals(280, supermarket.getTotal());
	}

	@Test
	public void mixedFruitSums480() {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		supermarket.scan("Cherries");
		supermarket.scan("Pommes");
		supermarket.scan("Cherries");
		supermarket.scan("Bananas");
		supermarket.scan("Bananas");
		supermarket.scan("Apples");
		assertEquals(480, supermarket.getTotal());
	}

	@Test
	public void mixedFruitSums200() {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		supermarket.scan("Mele");
		supermarket.scan("Pommes");
		supermarket.scan("Pommes");
		supermarket.scan("Mele");
		assertEquals(250, supermarket.getTotal());
		supermarket.scan("Bananas");
		assertEquals(200, supermarket.getTotal());
	}

	@Test
	public void mixedFruitSums150() {
		SuperMarketCheckout supermarket = new SuperMarketCheckout();
		supermarket.scan("Mele");
		supermarket.scan("Pommes");
		supermarket.scan("Pommes");
		supermarket.scan("Apples");
		supermarket.scan("Mele");
		assertEquals(150, supermarket.getTotal());
	}
}
