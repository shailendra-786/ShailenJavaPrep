package com.leetarray;

public class NumberOfCoinToss {
	 
    public static void main(String[] args) {
        // Step 1: Define the number of coin tosses
        int numTosses = 2;

        // Step 2: Calculate the probability of each combination of coin tosses
        double probability = 1.0 / Math.pow(2, numTosses);

        // Steps 3-5: Generate each possible combination of coin tosses and print its probability
        for (int i = 0; i < Math.pow(2, numTosses); i++) {
            String tosses = "";
            int num = i;
            for (int j = 0; j < numTosses; j++) {
                if (num % 2 == 0) {
                    tosses = "T" + tosses;
                } else {
                    tosses = "H" + tosses;
                }
                num /= 2;
            }
            System.out.println(tosses + " : " + probability);
        }
    }
}
