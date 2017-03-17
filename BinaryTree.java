package com.study;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
	private Node root;
	
	private static class Node {
		Node left;
		Node right;
		int data;
		
		Node( int data ) {
			this.left = null;
			this.right = null;
			this.data = data;
		}
	}
	
	public boolean lookup( int data ) {
		return lookup(root, data);
	}

	private boolean lookup(Node node, int data) {
		if ( node == null ) return false;
		if ( node.data == data ) return true;
		if ( data < node.data ) return lookup(node.left, data);
		if ( data > node.data ) return lookup(node.right, data);
		return false;
	}
	
	public BinaryTree insert ( int data ) {
		root = insert(root, data);
		return this;
	}
	
	private Node insert( Node node, int data ) {
		if(node == null ) {
			node = new Node(data);
		} else if (data <= node.data ) {
			node.left =  insert(node.left, data);
		} else {
			node.right =  insert(node.right, data);
		}
		return node;
	}
	
	public int maxDepth() {
		return maxDepth(root, 0);
	}
	
	private int maxDepth(Node node, int current) {
		//System.out.println((node == null ? "null" : node.data) + " - " + current);
		if ( node == null ) {
			return current;
		}
		current++;
		return Math.max(maxDepth(node.left, current), maxDepth(node.right, current));
	}
	
	public void print() {
		if ( root == null ) return;
		int depth = maxDepth();
		List<Node> thisLevel = new ArrayList<Node>();
		thisLevel.add(root);
		printLevel(thisLevel, 1, depth);
		
	}
	
	private static final int SPACES = 2;
	private static final int PADDING = 0;
	
	private void printLevel( List<Node> nodes, int level, int maxDepth) {
		if ( nodes == null || nodes.size() == 0 || allElementsNull(nodes)) {
			return;
		}
		List<Node> thisLevel = new ArrayList<Node>();
		
		int spacing = (int)(Math.pow(2, (maxDepth - level)) * SPACES) + PADDING;
		//System.out.println(level + " - " + spacing + " - " + maxDepth);
		StringBuilder sb = new StringBuilder();
		nodes.stream().forEach(n -> {
			String data = "";
			if ( n != null ) {
				data = n.data + "";
				thisLevel.add(n.left);
				thisLevel.add(n.right);
				
			} else {
				data = "";
				thisLevel.add(null);
				thisLevel.add(null);
			}
			sb.append(String.format("%" + spacing + "s%-" + spacing + "s", data, ""));
		});
		
		System.out.println(sb.toString());
		
		printLevel(thisLevel, ++level, maxDepth);
		
	}
	
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void inOrder(boolean desc) {
		inOrder(root, desc);
	}
	
	
	
	private void preOrder(Node node) {
		if ( node != null ) {
			System.out.print(String.format("%3d", node.data));
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	private void inOrder(Node node, boolean desc) {
		if ( node != null ) {
			if ( desc ) {
				inOrder(node.right, desc);
			} else {
				inOrder(node.left, desc);
			}
			System.out.print(String.format("%3d", node.data));
			if ( desc ) {
				inOrder(node.left, desc);
			} else {
				inOrder(node.right, desc);
			}
		}
	}

	private boolean allElementsNull(List<Node> nodes) {
		if ( nodes == null || nodes.size() == 0 ) {
			return true;
		}
		return nodes.stream().allMatch(i -> i == null);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(4).insert(2).insert(6).insert(1).insert(9).insert(5).insert(7).insert(11).insert(-3);
		bt.print();
		bt.preOrder();
		System.out.println("\n");
		bt.inOrder(true);
		System.out.println("\n");
		bt.inOrder(false);
	}
}
