package com.tonyzhai.practise.five;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2/2/2016.
 */
public class BinaryTree {
    Node root;
    class Node{
        int data;
        Node left;
        Node right;

        Node(){}

        Node(int data){
            this.data = data;
        }
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return;
        }
        Node temp = root;
        Node previous = root;
        while(temp != null){
            previous = temp;
            if(data > temp.data){
                temp = temp.right;
                if(temp == null){
                    previous.right = newNode;
                }
            } else if(data < temp.data){
                temp = temp.left;
                if(temp == null){
                    previous.left = newNode;
                }
            } else{
                break;
            }
        }
    }

    public void delete(int data){
        if(root == null) return;
        Node temp = root;
        Node previous = root;
        boolean isLeft = true;
        while(temp != null){
            previous = temp;
            if(data == temp.data){
                if(temp.left == null && temp.right == null){
                    if(temp.data == root.data){
                        root = null;
                    } else{
                        if(isLeft){
                            previous.left = null;
                        } else{
                            previous.right = null;
                        }
                    }
                    return;
                } else if(temp.left == null){
                    if(temp.data == root.data){
                        root = root.right;
                    } else{
                        if(isLeft){
                            previous.left = temp.right;
                        } else{
                            previous.right = temp.right;
                        }
                    }
                } else if(temp.right == null){
                    if(temp.data == root.data){
                        root = root.left;
                    } else{
                        if(isLeft){
                            previous.left = temp.left;
                        } else{
                            previous.right = temp.left;
                        }
                    }
                } else{

                }
            } else if(data > temp.data){
                temp = temp.right;
                isLeft = false;
            } else if(data < temp.data){
                temp = temp.left;
                isLeft = true;
            }
        }
    }

    public void preOrder(){
        if(root == null) return;
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        if(root == null) return;
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(){
        if(root == null) return;
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void bfs(){
        Queue<Node> queue = new LinkedList<>();
        if(root == null) return;
        queue.add(root);
        Node temp = root;
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }

    public void dfs(){
        Stack<Node> queue = new Stack<>();
        if(root == null) return;
        queue.add(root);
        Node temp = root;
        while(!queue.isEmpty()){
            temp = queue.pop();
            System.out.print(temp.data + " ");
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(4);
        tree.add(7);
        tree.add(3);
        System.out.println("pre order");
        tree.preOrder();
        System.out.println();
        System.out.println("in order");
        tree.inOrder();
        System.out.println();
        System.out.println("post order");
        tree.postOrder();
        System.out.println();
        System.out.println("bfs");
        tree.bfs();
        System.out.println();
        System.out.println("dfs");
        tree.dfs();
    }
}
