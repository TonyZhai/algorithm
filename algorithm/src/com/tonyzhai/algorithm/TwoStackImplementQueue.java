package com.tonyzhai.algorithm;

import java.util.Stack;

/**
 * /**
 * used two stack to implement FIFO queue
 * 
 * Condition: just can use pop and push method of stack
 * 
 * @author tonyzhai
 *
 * @param <T>
 */
public class TwoStackImplementQueue<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	
	/**
	 * push element to queue
	 * 
	 * @param t
	 */
	public void push(T t){
		System.out.println("push " + t + " to stack1");
		stack1.push(t);
	}
	
	/**
	 * my original implementation: 
	 * 
	 * 1: save all stack1 elements to stack2
	 * 
	 * 2: get stack2 first element
	 * 
	 * 3: save all stack2 elements to stack1
	 * 
	 * 4: return step2 value
	 * 
	 * @return
	 */
	public T pullOriginal(){
		T t = stack1.pop();
		if(t == null){
			System.out.println("stack1 is empty");
			return null;
		}
		System.out.println("pop " + t + " from stack1");
		while(t != null){
			stack2.push(t);
			System.out.println("push " + t + " to stack2");
			t = stack1.pop();
			if(t == null){
				System.out.println("stack1 is empty");
				break;
			}
			System.out.println("pop " + t + " from stack1");
		}
		T popValue =  stack2.pop();
		System.out.println("get and pop " + popValue + " from stack2");
		t = stack2.pop();
		if(t == null){
			System.out.println("stack2 is empty");
		}else{
			System.out.println("pop " + t + " from stack2");
		}
		while(t != null){
			stack1.push(t);
			System.out.println("push " + t + " to stack1");
			t = stack2.pop();
			if(t == null){
				System.out.println("stack2 is empty");
				break;
			}
			System.out.println("pop " + t + " from stack2");
		}
		System.out.println("return " + popValue + " from stack2");
		return popValue;
	}
	
	/**
	 * my new implementation: 
	 * 
	 * I found after save all stack1 elements to stack2, if stack2 is not empty, we can continue to pop its elements until it is empty
	 * 
	 * @return
	 */
	public T pullNew(){
		T popValue = stack2.pop();
		if(popValue != null){
			//if stack2 is not empty, pop element directly
			System.out.println("return " + popValue + " from stack2");
			return popValue;
		}else{
			//if stack2 is empty, add all of the stack1 elemetns to stack2
			T t = stack1.pop();
			if(t == null){
				System.out.println("stack1 is empty");
				return null;
			}
			System.out.println("pop " + t + " from stack1");
			while(t != null){
				stack2.push(t);
				System.out.println("push " + t + " to stack2");
				t = stack1.pop();
				if(t == null){
					System.out.println("stack1 is empty");
					break;
				}
				System.out.println("pop " + t + " from stack1");
			}
		}
		popValue = stack2.pop();
		System.out.println("return " + popValue + " from stack2");
		return popValue;
	}
	
	public static void main(String[] args){
		TwoStackImplementQueue<Integer> queue = new TwoStackImplementQueue<Integer>();
//		queue.push(1);
//		queue.push(2);
//		queue.pullOriginal();
//		queue.push(3);
//		queue.pullOriginal();
//		queue.pullOriginal();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.pullNew();
		queue.push(5);
		queue.push(6);
		queue.pullNew();
		queue.pullNew();
		queue.push(7);
		queue.pullNew();
		queue.pullNew();
		queue.pullNew();
		queue.pullNew();
	}
}
