package com.tonyzhai.datastructure;

public class LinkedList<E> {
    private Node head;
    private int size;

    public LinkedList(){
        head = new Node();
    }

    class Node{
        private E data;
        private Node next;

        public Node(){
        }

        public Node(E data){
            this.data = data;
        }
    }

    public void insertFirst(E e){
        Node node = new Node(e);
        if(head.next != null){
            node.next = head.next;
        }
        head.next = node;
        size++;
    }

    public void insert(E e, int index){
        if(!isPositionIndex(index)){
            System.out.println("index out of round");
            return;
        }
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        Node node = new Node(e);
        node.next = current.next;
        current.next = node;
        size++;
    }

    public void removeFirst(){
        if(head.next != null){
            head.next = head.next.next;
            size--;
        }else{
            System.out.println("list is empty");
        }
    }

    public E get(int index){
        return getNodeByIndex(index).data;
    }

    private Node getNodeByIndex(int index){
        if(!isElementIndex(index)){
            System.out.println("index out of round");
            return null;
        }
        Node current = head;
        for(int i = 0; i <= index; i++){
            current = current.next;
        }
        return current;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    public void remove(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        if(size == 0){
            System.out.println("list is empty");
            return;
        }
        if(!isElementIndex(index)){
            System.out.println("index out of round");
            return;
        }
        Node preNode = getNodeByIndex(index - 1);
        Node node = getNodeByIndex(index);
        preNode.next = node.next;
        size--;
    }

    public int size(){
        return size;
    }


    public void display() {
        Node current = head;
        while(current.next != null){
            System.out.println(current.next.data);
            current = current.next;
        }
    }

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();
        System.out.println("==========");
        list.removeFirst();
        list.display();
        System.out.println("==========");
        list.removeFirst();
        list.display();
        System.out.println("==========");
        list.removeFirst();
        list.display();
        System.out.println("==========");
        list.removeFirst();
        list.display();
        System.out.println("==========");
        list.removeFirst();
        list.display();
        System.out.println("==========");
        list.insert(5, 3);
        list.display();
        System.out.println("==========");
        list.insert(5, 0);
        list.display();
        System.out.println("==========");
        list.insert(6, 1);
        list.display();
        System.out.println("==========");
        list.insert(7, 1);
        list.display();
        System.out.println("==========");
        System.out.println(list.get(2));
        System.out.println("==========");
        list.remove(2);
        list.display();
        System.out.println("==========");
        System.out.println("current list size is " + list.size());
    }
}
