package com.nhpatt.checkout;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class SuperMarketCheckout {

	private Integer total = 0;
	private final String[] elements = new String[] { "Apples", "Cherries",
			"Bananas", "Pommes", "Mele" };

	private final Map<String, Integer> counts = new HashMap<String, Integer>() {
		{
			for (String element : elements) {
				put(element, 0);
			}
		}
	};

	private final Integer[][] data = new Integer[][] {
			{ 100, 75, 150, 100, 100 }, { 1, 2, 2, 3, 2 },
			{ 0, 20, 150, 100, 50, }, };

	private final Map<String, Integer[]> prizes = new HashMap<String, Integer[]>() {
		{
			for (int i = 0; i < elements.length; i++) {
				put(elements[i], new Integer[] { data[0][i], data[1][i],
						data[2][i] });
			}
		}
	};

	public void scan(String element) {
		if (counts.containsKey(element)) {
			counts.put(element, counts.get(element) + 1);
			sumPrize(element);
			applyNormalDiscount(element);
			applyFruitDiscount();
			if (isApple(element)) {
				applyAppleDiscount();
			}
		}

	}

	private void applyAppleDiscount() {
		if (countApple() % 4 == 0) {
			total -= 100;
		}

	}

	private void applyFruitDiscount() {
		if (countFruit() % 5 == 0) {
			total -= 200;
		}

	}

	private int countFruit() {
		Integer total = 0;
		for (String element : counts.keySet()) {
			total += counts.get(element);
		}
		return total;
	}

	private int countApple() {
		Integer total = 0;
		for (String element : counts.keySet()) {
			if (isApple(element)) {
				total += counts.get(element);
			}
		}
		return total;
	}

	private boolean isApple(String element) {
		return element.equals("Apples") || element.equals("Mele")
				|| element.equals("Pommes");
	}

	private void sumPrize(String element) {
		total += prizes.get(element)[0];
	}

	private void applyNormalDiscount(String element) {
		total -= counts.get(element) % prizes.get(element)[1] == 0 ? prizes
				.get(element)[2] : 0;
	}

	public int getTotal() {
		return total;
	}

}
