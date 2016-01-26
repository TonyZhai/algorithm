package com.tonyzhai.datastructure;

public class Queue {
	private Node front;
	private Node rear;
	private int size;
	
	public Queue(){
		Node n=new Node();  
        front = rear = n;  
	}
	class Node{
		private int data;
		private Node next;
		public Node(){
		}
		public Node(int data){
			this.data = data;
		}
	}
	
	public void enqueue(int data){
		Node node = new Node(data);
		rear.next = node;
		rear = node;
		size++;
	}
	
	public Integer dequeue(){
		if(size == 0){
			System.out.println("queue is empty");
			return null;
		} else{
			int data = front.next.data;
			front.next = front.next.next;
			size--;
			return data;
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public static void main(String[] args){
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
        System.out.println("dequeue" + queue.dequeue());
        System.out.println("queue size is " + queue.size());  
	}
}
