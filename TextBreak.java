package com.study;

public class TextBreak {
	private static int LIMIT = 10;
	public static void main(String[] args) {
		String input = "abcdefghijk";
		//String input = "IllegalArgumentException(InventoryProfile without PredicateConfig can not be converted!);";
		if ( input == null || input.length() == 0 ) return;
		int len = input.length();
		int maxDigits = 1;
		for ( int i=1; i < len-2; i++) {
			int maxSplits = (int)Math.pow(10, i) - 1;
			int maxCost = costOf(maxSplits);
			int maxCharsSupported =   (maxSplits * LIMIT ) - maxCost;
			System.out.println(i + " = " + maxCharsSupported);
			if ( maxCharsSupported >= len ) {
				maxDigits = i;
				break;
			}
		}
		System.out.println("maxDigits = " + maxDigits);
	}
	
	private static int costOf(int n) {
		int cost = 0;
		for ( int i=1; i<= n; i++) {
			cost += digitsOf(i);
		}
		return cost + n + (n * digitsOf(n));
		//System.out.println(n + " = " + cost + " & " + (double)cost/LIMIT);
	}
	
	private static int digitsOf( int input ) {
		return (int)Math.log10(input) + 1;
	}
}
