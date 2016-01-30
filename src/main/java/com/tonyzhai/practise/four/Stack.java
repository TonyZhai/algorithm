package com.tonyzhai.practise.four;

public class Stack {
    int[] elements;
    int size;
    int capacity;
    public Stack(){
        this(10);
    }
    public Stack(int capacity){
        this.capacity = capacity;
        elements = new int[capacity];
    }
    public void push(int data){
        if(size < capacity){
            System.out.println("push stack " + data);
            elements[size++] = data;
        } else{
            System.out.println("stack is full");
        }
    }
    public int pop(){
        if(size > 0){
            int data = elements[--size];
            System.out.println("pop stack " + data);
            return data;
        }else{
            System.out.println("stack is empty");
            return - 1;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }
}
