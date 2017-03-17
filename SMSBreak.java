package com.study;

public class SMSBreak {
	private static final int LIMIT = 10;
	
	public static void main(String[] args) {
		String input = "IllegalArgumentException(InventoryProfile without PredicateConfig can not be converted!);";
		//String input = "Illegalrty";
		if ( input == null || input.length() == 0 ) return;
		int numOfSplits = numOfSplits(input);

		if ( numOfSplits <= 1 ) {
			System.out.println(input);
			return;
		}
		
		int tokenNum = 1;
		while ( input.length() > 0) {
			String append = tokenNum + "/"+ numOfSplits;
			int cur_limit = LIMIT - append.length();
			cur_limit = cur_limit > input.length() ? input.length() : cur_limit;
			System.out.println("\"" + append + input.substring(0, cur_limit) + "\"");
			input = input.substring(cur_limit);
			tokenNum++; 
		}
	}
	
	private static int numOfSplits ( String input ) {
		int len = input.length();
		int numOfSplits = 1;
		for ( int i= 1; i<=len; i++) {
			double cost = costOf(i, len);
			System.out.println(i + " = " + cost);
			if ( cost >= 0) {
				numOfSplits = i;
				break;
			}
		}
		return numOfSplits;
	}
	
	private static double costOf(int n, int N) {
		double cost = 0;
		for ( int i=1; i<= n; i++) {
			cost += digitsOf(i);
		}
		cost += n + (n * digitsOf(n)) + N;
		//System.out.println(n + " = " + cost + " & " + (double)cost/LIMIT);
		return n - cost/LIMIT;
	}
	
	private static int digitsOf( int input ) {
		return (int)Math.log10(input) + 1;
	}

}
