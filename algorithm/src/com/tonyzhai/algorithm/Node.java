package com.tonyzhai.algorithm;


/**
 * reverse link list
 * 
 * Condition: Memory need O(1), time need O(n)
 * 
 * @author tonyzhai
 *
 * @param <T>
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node() {}
	
	public Node(T data) {
		super();
		this.data = data;
	}
	
	/**
	 * just define three variable no matter how many nodes, so the memory is O(1), just one time traverse list, so time is O(n) 
	 * 
	 * @param head
	 * @return
	 */
	public static<T> Node<T> reverse(Node<T> head){
		if(head == null || head.next == null){
			//empty or just have one element
			return head;
		}
		//assume 1,2,3 case
		Node<T> previous = head; //previous variable point to 1 
        Node<T> current = head.next; //current variable point to 2 
        Node<T> next; //next variable point to null now
        while (current != null) { 
        	//assume first loop, now next variable point to 3
        	//assume second loop, now next variable point to null
            next = current.next;
            //first loop: let node 2's next point to node 1
            //second loop: let node 3's next point to node 2
            current.next = previous;
            //first loop: previous variable point to 2, identity next while loop's previous element
            //second loop: previous variable point to 3, identity next while loop's previous element
            previous = current;  
            //first loop: current variable point to 3, identity next while loop's current element
            //second loop: current variable point to null, the while loop will exit
            current = next;  
        }  
        //set head next to null, the head node is the last node of new list
        head.next = null;
        //after second loop, now the previous point 3, 3 is the new list's first node, so let head point to previous
        head = previous;  
        return head;  
	}
	
	public static<T> void print(Node<T> head){
		if(head == null){
			return;
		}
		while(head != null){
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static void main(String[] args){
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		head.next = node2;
		node2.next = node3;
		Node.print(head);
		System.out.println("---------");
		Node<Integer> newHead = Node.reverse(head);
		Node.print(newHead);
	}
}
