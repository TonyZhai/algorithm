package com.tonyzhai.practise.two;

/**
 * Created by Administrator on 1/27/2016.
 */
public class LinkedList<T> {
    int size;
    Node<T> head;
    Node<T> rear;

    public LinkedList(){

    }
    public void add(T data){
        if(head == null){
            head = new Node(data);
            rear = head;
        } else{
            rear.next = new Node(data);
            rear = rear.next;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        if(size <= 0 || index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index is " + index);
        }
        int i = 0;
        Node temp = head;
        while(i != index){
            temp = temp.next;
            i++;
        }
        return (T)temp.data;
    }

    public void remove(int index){
        if(size <= 0 || index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index is " + index);
        }
        int i = 0;
        Node temp = head;
        while(i != index - 1){
            temp = temp.next;
            i++;
        }
        if(temp.next.next != null){
            temp.next = temp.next.next;
        } else{
            temp.next = null;
        }
        size--;
    }

    public void reverse(){
        if(head == null || head.next == null){
            return;
        }
        Node previous = head;
        Node current = head.next;
        Node temp = head;
        while(current != null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head.next = null;
        head = previous;
    }

    class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
        Node(){
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
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
        list.reverse();
        System.out.println(list.get(5));

        list.remove(8);
        System.out.println(list.get(8));

    }
}
