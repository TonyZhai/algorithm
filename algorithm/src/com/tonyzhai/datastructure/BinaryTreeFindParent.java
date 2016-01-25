package com.tonyzhai.datastructure;

import java.util.List;

public class BinaryTreeFindParent {
	private Node root;
	private ArrayList<Integer> temp1 = new ArrayList<>();
	private ArrayList<Integer> temp2 = new ArrayList<>();
	
	public ArrayList<Integer> getTemp1() {
		return temp1;
	}
	public void setTemp1(ArrayList<Integer> temp1) {
		this.temp1 = temp1;
	}
	public ArrayList<Integer> getTemp2() {
		return temp2;
	}
	public void setTemp2(ArrayList<Integer> temp2) {
		this.temp2 = temp2;
	}
	
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public BinaryTreeFindParent(){}
	
	class Node{
		private int data;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int data){
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(Node leftChild) {
			this.leftChild = leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public void setRightChild(Node rightChild) {
			this.rightChild = rightChild;
		}
		
	}
	
	public void preTraverseFindPath(Node node, int data){
		if(node == null){
			return;
		}
		temp1.add(node.getData());
		if(node.getData() == data){
			for(int i = 0; i < temp1.size(); i++){
				temp2.add(temp1.get(i));
			}
			return;
		}
		preTraverseFindPath(node.getLeftChild(), data);
		preTraverseFindPath(node.getRightChild(), data);
		temp1.remove(node.getData());
	}
	
	
	private static void printTree(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");
		printTree(node.leftChild);
		printTree(node.rightChild);
	}
	public static void printPathWithSum(Node root, int sum){
		printPathWithSum(root, new java.util.ArrayList<Integer>(), 0, sum);
	}
	private static void printPathWithSum(Node node, List<Integer> pathList, int temp, int sum) {
		if(node == null){
			return;
		}
		temp += node.data;
		pathList.add(node.data);
		
		if(node.leftChild == null && node.rightChild == null && temp == sum){
			System.out.print("sumPath(" + sum + "): ");  
            for (Integer i : pathList) {  
                System.out.print(i + " ");  
            }  
            System.out.println();  
		}
		
		printPathWithSum(node.leftChild, pathList, temp, sum);
		printPathWithSum(node.rightChild, pathList, temp, sum);
		pathList.remove(pathList.size() - 1);
	}
	public static void main(String[] args){
		BinaryTreeFindParent tree = new BinaryTreeFindParent();
		Node node1 = tree.new Node(1);
		Node node2 = tree.new Node(2);
		Node node3 = tree.new Node(3);
		Node node4 = tree.new Node(4);
		Node node5 = tree.new Node(5);
		Node node6 = tree.new Node(6);
		Node node7 = tree.new Node(7);
		Node node8 = tree.new Node(8);
		tree.setRoot(node1);
		node1.setLeftChild(node2);
		node1.setRightChild(node3);
		node2.setLeftChild(node4);
		node2.setRightChild(node5);
		node3.setLeftChild(node6);
		node3.setRightChild(node7);
		node4.setLeftChild(node8);
		
		
		tree.preTraverseFindPath(tree.getRoot(),4);
		int[] path1 = new int[8];
		System.out.print("path 4->");
		for(int i = 0; i < tree.getTemp2().size(); i++){
			path1[i] = tree.getTemp2().get(i);
			System.out.print(path1[i]);
		}
		
		tree.getTemp1().clear();
		tree.getTemp2().clear();
		
		tree.preTraverseFindPath(tree.getRoot(),7);
		int[] path2 = new int[8];
		System.out.println();
		System.out.print("path 7->");
		for(int i = 0; i < tree.getTemp2().size(); i++){
			path2[i] = tree.getTemp2().get(i);
			System.out.print(path2[i]);
		}
		System.out.println();
		int result = 0;
		for(int i = 0; i < path1.length; i++){
			if(path1[i] !=0 && path2[i] != 0 && path1[i] == path2[i]){
				result = path1[i];
			}
		}
		
		System.out.println("these two nodes's closest parent node is " + result);
		
		
		BinaryTreeFindParent tree1 = new BinaryTreeFindParent();
		Node node11 = tree.new Node(10);
		Node node12 = tree.new Node(5);
		Node node13 = tree.new Node(12);
		Node node14 = tree.new Node(4);
		Node node15 = tree.new Node(7);
		tree1.setRoot(node11);
		node11.setLeftChild(node12);
		node11.setRightChild(node13);
		node12.setLeftChild(node14);
		node12.setRightChild(node15);
		
		printTree(tree1.root);
		System.out.println();  
		printPathWithSum(tree1.root, 22);
	}
}
