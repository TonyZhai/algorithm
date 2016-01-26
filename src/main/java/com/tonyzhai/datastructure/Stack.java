package com.tonyzhai.datastructure;

/**
 * linked stack
 * 
 * @author tonyzhai
 *
 * @param <T>
 */
public class Stack<T> {
	private Node<T> top;
	private int size;
	class Node<E>{
		private E data;
		private Node<E> next;
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	public void push(T data){
		top = new Node<T>(data, top);
		size++;
	}
	public T pop(){
		if(size == 0){
			return null;
		}
		T data = top.data;
		top = top.next;
		size--;
		return data;
	}
	
	public static void main(String[] args) {  
        Stack<Integer> stack = new Stack<Integer>();  
        stack.push(1);  
        stack.push(2);  
        stack.push(3);  
        stack.push(4);  
        System.out.println("first pop: " + stack.pop());  
        System.out.println("second pop " + stack.pop());  
    }  
}
