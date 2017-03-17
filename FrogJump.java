package com.study;

import java.util.ArrayList;
import java.util.List;

public class FrogJump {
	public void jumps_1 ( int n, List<String> jumps) {
		if ( jumps.size() == 0 ) { jumps.add(""); }
		if ( n <= 0) { return; }
		
		List<String> oneHop = new ArrayList<String>();
		List<String> twoHop = new ArrayList<String>();
		for ( String jump : jumps ) {
			oneHop.add(jump + "1");
			if ( n > 1 ) { twoHop.add(jump + "2"); }
		}
		List<String> newJumps = new ArrayList<String>();
		newJumps.addAll( jumps(n-1, oneHop) );
		if ( n > 1 ) { newJumps.addAll( jumps(n-2, twoHop) ); }
		jumps.clear();
		jumps.addAll(newJumps);
	}
	
	public List<String> jumps ( int n, List<String> jumps) {
		//System.out.println(String.format("Calculating jumps for %d", n));
		//jumps.stream().forEach(s -> System.out.println(s));
		
		if ( n == 0) {
			//Reached the end;
			return jumps;
		}
		
		if ( n == 1 ) {
			if ( jumps.size() == 0 ) {
				jumps.add("1");
				return jumps;
			} else {
				List<String> newJumps = new ArrayList<String>();
				for ( String jump : jumps ) {
					newJumps.add(jump + "1");
				}
				return newJumps;
			}
		} else {
			if ( jumps.size() == 0 ) {
				jumps.add("");
			} 
			
			List<String> oneHop = new ArrayList<String>();
			List<String> twoHop = new ArrayList<String>();
			for ( String jump : jumps ) {
				oneHop.add(jump + "1");
				twoHop.add(jump + "2");
			}
			List<String> newJumps = new ArrayList<String>();
			newJumps.addAll( jumps(n-1, oneHop) );
			newJumps.addAll( jumps(n-2, twoHop) );
			return newJumps;
		}
	}
	
	
	
	public static void main(String[] args) {
//		List<String> result = new ArrayList<>();
//		FrogJump f = new FrogJump();
//		f.jumps_1(1, result);
//		result.stream().forEach(s -> System.out.println(s));
		int num1=11,num2=12;
		System.out.print(String.format("%5d%-5s", num1,""));
		System.out.print("Hello");
	}
}
