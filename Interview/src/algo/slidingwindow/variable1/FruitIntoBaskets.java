package algo.slidingwindow.variable1;

import java.util.HashMap;

public class FruitIntoBaskets {
	public static int totalFruit(int[] fruits) {
		HashMap<Integer, Integer> basket = new HashMap<>();
		int left = 0, maxFruits = 0;

		for (int right = 0; right < fruits.length; right++) {
			basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

			while (basket.size() > 2) {
				basket.put(fruits[left], basket.get(fruits[left]) - 1);
				if (basket.get(fruits[left]) == 0) {
					basket.remove(fruits[left]);
				}
				left++; // Shrink window
			}

			maxFruits = Math.max(maxFruits, right - left + 1);
		}

		return maxFruits;
	}

	public static void main(String[] args) {
		System.out.println(totalFruit(new int[] { 1, 2, 1 })); // Output: 3
		System.out.println(totalFruit(new int[] { 0, 1, 2, 2 })); // Output: 3
		System.out.println(totalFruit(new int[] { 1, 2, 3, 2, 2 })); // Output: 4
	}
}
