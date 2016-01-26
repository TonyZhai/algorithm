package com.tonyzhai.algorithm;

import java.util.LinkedList;

/**
 * ?????2
 * 		????min????
 *
 * ??
 * 		???????????????min??????????????
 *		????min?push??pop????????O(1)?
 *
 * @author tony
 */
public class StackWithGetMinMethod {
	private int[] data;
	private LinkedList<Integer> indexList;
	private int size;

	public StackWithGetMinMethod(int size){
		data = new int[size];
		size = 0;
		indexList = new LinkedList<>();
	}

	public void pop(){
		if(size == 0){
			System.out.println("stack is empty");
			return;
		}
		int index = indexList.get(0);
		if((size-1) == index){
			indexList.removeFirst();
		}
		size--;
	}

	public void push(int value){
		if(size == 0){
			indexList.addFirst(size);
		}else{
			int minValue = data[indexList.get(0)];
			if(value < minValue){
				indexList.addFirst(size);
			}
		}
		data[size] = value;
		size++;
	}


	public int getMinValue(){
		if(indexList.size() == 0){
			return - 1;
		}
		return data[indexList.get(0)];
	}

	public static void main(String[] args){
		int[] data = {5, 4, 2, 2, 6, 2, 1, 1, 1, 3};
		StackWithGetMinMethod stack = new StackWithGetMinMethod(10);
		for(int i : data){
			stack.push(i);
			System.out.println("push value is " + i + ", current min value is " + stack.getMinValue());
		}
		for(int i = data.length - 1; i >= 0; i--){
			stack.pop();
			if(stack.getMinValue() == -1){
				System.out.println("pop value is " + data[i] + ", stack is empty");
			}else{
				System.out.println("pop value is " + data[i] + ", current min value is " + stack.getMinValue());
			}
		}
	}
}