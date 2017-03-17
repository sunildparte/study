package com.study;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap = new ArrayList<Integer>();
	
	public MinHeap insert( int data ) {
		heap.add(data);
		if ( heap.size() == 1) return this;
		int i = heap.size() - 1;
		int parent;
		
		//bubble up
		do {
			parent = (i + 1)/2 -1;
			if ( heap.get(i) < heap.get(parent)) {
				swap(heap, i, parent);
				i = parent;
			} else {
				break;
			} 
		}while( i != 0);
		return this; //Returning this - useful for chaining insert calls.
	}
	
	public Integer extractMin () {
		if ( heap.size() == 0 ) return null;
		int result = heap.get(0);
		if ( heap.size() == 1 ) {
			heap.clear();
			return result;
		} 
		
		//Swap root with last element and remove last.
		swap(heap, 0, heap.size()-1);
		heap.remove(heap.size()-1);
		
		//bubble down	
		int last = heap.size() -1;
		int i = 0;
		while(true) {
			int leftChild = (i+1)*2 -1;
			int rightChild = (i+1)*2;
			if ( leftChild > last) {
				break; //Reached end
			} else {
				int minOfTwo;
				if ( leftChild == last) {
					minOfTwo = leftChild;
				} else {
					minOfTwo = heap.get(leftChild) < heap.get(rightChild) ? leftChild : rightChild;
				}
				
				if ( heap.get(i) > heap.get(minOfTwo)) {
					swap(heap, i, minOfTwo);
					i = minOfTwo;
				} else {
					break;
				}
			}
		}
		return result;
	}
	
	private void swap(List<Integer> heap, int i, int parent) {
		int tmp = heap.get(i);
		heap.set(i, heap.get(parent));
		heap.set(parent, tmp);
	}

	public String toString() {
		return heap.toString();
	}
	
	public static void main(String[] args) {
		//Test Code
		MinHeap bt = new MinHeap();
		bt.insert(4).insert(2).insert(6).insert(1).insert(9).insert(5).insert(7).insert(11).insert(-3);
		Integer i;
		do {
			i = bt.extractMin();
			System.out.println(i);
		} while ( i != null );
		
		
	}
}
