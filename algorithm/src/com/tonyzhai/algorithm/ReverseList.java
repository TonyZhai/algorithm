package com.tonyzhai.algorithm;

public class ReverseList<E> {
	private Node<E> head;
	public Node<E> reverst(Node<E> head){
		 if(head == null || head.next == null){
			 return head;  
		 }
	        Node<E> pre = head;  
	        Node<E> cur = head.next;  
	          
	        while(cur != null)  
	        {  
	            Node<E> temp = cur.next;  
	            cur.next = pre;  
	            pre = cur;  
	            cur = temp;  
	        }  
	          
	        head.next = null;  
	          
	        return head;  
	}
	
	class Node<T>{
		private T data;
		private Node<T> next;
		public Node(){
		}
		public Node(T t){
			this.data = t;
		}

		public void setData(T data) {
			this.data = data;
		}
	}
	
	public void init(E[] data){
		if(head == null){
			head = new Node<E>();
		}
		for(int i = 0; i < data.length; i++){
			Node<E> node = new Node<E>(data[i]);
			head.next = node;
			head = node;
		}
	}
	
	public void printList(){
		while(head.next!=null){
			System.out.println(head.next.data);
			head = head.next;
		}
	}
	
	public static void main(String[] args){
		ReverseList<Integer> reverseList = new ReverseList<Integer>();
		Integer[] data = {1,2,3};
		reverseList.init(data);
		reverseList.printList();
	}
}
