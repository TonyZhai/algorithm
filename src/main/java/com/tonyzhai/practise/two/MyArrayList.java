package com.tonyzhai.practise.two;

/**
 * Created by Administrator on 1/27/2016.
 */
public class MyArrayList<T> {
    private Object[] elements;
    private int size;
    private int capacity;

    public MyArrayList(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("capacity couldn't be less than 0");
        }
        this.capacity = capacity;
        elements = new Object[capacity];
    }

    public MyArrayList(){
        this(10);
    }

    public void add(T data){
        ensureCapacity();
        elements[size++] = data;
    }

    public T get(int index){
        if(size <= 0 || index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index is " + index);
        }
        return (T)elements[index];
    }

    public void remove(int index){
        if(size <= 0 || index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index is " + index);
        }
        for(int i = index; i < size; i++){
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public int size(){
        return size;
    }

    private void ensureCapacity() {
        if(size == capacity){
            Object[] newArray = new Object[capacity * 2];
            for(int i = 0; i < size; i++){
                newArray[i] = elements[i];
            }
            elements = newArray;
            capacity = capacity * 2;
        }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);


    }
}
