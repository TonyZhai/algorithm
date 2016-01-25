package com.tonyzhai.datastructure;

public class ArrayList<E> {
	private Object[] data;
	private int currentSize;
	private int capacity = 10;
	
	public ArrayList(){
		this(10);
	}
	
	public ArrayList(int size){
		data = new Object[size];
		this.currentSize = 0;
		this.capacity = size;
	}
	public void add(E e){
		ensureCapacity();
		data[currentSize++] = e;
	}
	
	private void ensureCapacity(){
		if(currentSize == capacity){
			//if full, add capacity
			System.out.println("need add capacity, current size is " + capacity);
			Object[] newData = new Object[capacity * 2];
			for(int i = 0; i < currentSize; i++){
				newData[i] = data[i];
			}
			data = newData;
			capacity = newData.length;
			System.out.println("after add capacity, size is " + capacity);
		}
	}
	
	@SuppressWarnings("unchecked")
	public E get(int index){
		return (E)data[index];
	}
	
	public void set(int index, E e){
		data[index] = e;
	}
	
	public void delete(int index){
		for(int i = index; i < currentSize; i++){
			data[i] = data[i+1];
		}
		currentSize--;
	}
	
	public void remove(E e){
		for(int i = 0; i < currentSize; i++){
			if(e == data[i]){
				delete(i);
			}
		}
	}
	
	public void clear(){
		currentSize = 0;
	}
	
	public void insert(int index, E e){
		ensureCapacity();
		for(int i = currentSize - 1; i >= index; i--){
			data[i+1] = data[i];
		}
		data[index] = e;
		currentSize++;
	}
	
	public int size(){
		return this.currentSize;
	}
}
