package com.nhpatt.checkout;

import java.util.HashMap;

public class Checkout {

	private final String[] fruits = new String[] { "Apples", "Bananas",
			"Cherries", "Pommes", "Mele" };
	private final Integer[] fruitPrizes = new Integer[] { 100, 150, 75, 100,
			100 };
	private final Integer[] quantityDiscounts = new Integer[] { 1, 2, 2, 3, 2, };
	private final Integer[] discount = new Integer[] { 0, 150, 20, 100, 50, };
	private final HashMap<String, Integer[]> discounts = new HashMap<String, Integer[]>();
	private final HashMap<String, Integer> count = new HashMap<String, Integer>();
	private final HashMap<String, Integer> prizes = new HashMap<String, Integer>();
	private Integer total = 0;

	public Checkout() {
		for (String fruit : fruits) {
			count.put(fruit, 0);
		}
		for (int i = 0; i < fruits.length; i++) {
			prizes.put(fruits[i], fruitPrizes[i]);
		}
		for (int i = 0; i < fruits.length; i++) {
			discounts.put(fruits[i], new Integer[] { quantityDiscounts[i],
					discount[i] });
		}
	}

	public void scan(String element) {
		if (prizes.containsKey(element)) {
			total += prizes.get(element);
			count.put(element, count.get(element) + 1);
			applyDiscounts(element);
			if (isApple(element)) {
				applyApplesDiscount();
			}
			applyFruitDiscount();
		}
	}

	private void applyApplesDiscount() {
		if (countApples() % 4 == 0) {
			total -= 100;
		}
	}

	private void applyFruitDiscount() {
		if (countFruits() % 5 == 0) {
			total -= 200;
		}
	}

	private void applyDiscounts(String element) {
		if (count.get(element) % discounts.get(element)[0] == 0) {
			total -= discounts.get(element)[1];
		}
	}

	private Integer countApples() {
		Integer totalFruits = 0;
		for (String key : count.keySet()) {
			if (isApple(key)) {
				totalFruits += count.get(key);
			}
		}
		return totalFruits;
	}

	private Integer countFruits() {
		Integer totalFruits = 0;
		for (String key : count.keySet()) {
			totalFruits += count.get(key);
		}
		return totalFruits;
	}

	private boolean isApple(String element) {
		return element.equals("Apples") || element.equals("Pommes")
				|| element.equals("Mele");
	}

	public int getTotal() {
		return total;
	}

}
