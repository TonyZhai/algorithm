package com.tonyzhai.practise.two;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by Administrator on 1/27/2016.
 */
public class BinaryTree<T extends  Comparable<T>> {
    Node root;
    public void inOrderTraverse(Node node){
        if(node != null){
            inOrderTraverse(node.left);
            System.out.print(node.data + " ");
            inOrderTraverse(node.right);
        }
    }

    public void preOrderTraverse(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    public void postOrderTraverse(Node node){
        if(node != null){
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void breadthFirstTraverse(Node node){
        if(node != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()){
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
    }

    public void depthFirstTraverse(Node node){
        if(node != null){
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while(!stack.isEmpty()){
                Node temp = stack.pop();
                System.out.print(temp.data + " ");
                if(temp.right != null) stack.push(temp.right);
                if(temp.left != null) stack.push(temp.left);
            }
        }
    }


    public void addNode(T data){
        Node node = new Node(data);
        if(node == null) return;
        if(root == null) {
            root = node;
            return;
        }
        Node temp = root;
        while(true){
            if(node.compareTo(temp) > 0){
                if(temp.right == null){
                    temp.right = node;
                } else{
                    temp = temp.right;
                    continue;
                }
            } else if(node.compareTo(temp) < 0){
                if(temp.left == null){
                    temp.left = node;
                } else{
                    temp = temp.left;
                    continue;
                }
            } else{
                break;
            }
        }

    }

    public T getMax(){
        if(root == null) return null;
        return (T)getMaxNode(root.right).data;
    }

    private Node getMaxNode(Node node) {
        Node maxNode = node;
        if(maxNode.right != null){
            maxNode = getMaxNode(maxNode.right);
        }
        return maxNode;
    }

    public T getMin(){
        if(root == null) return null;
        return (T)getMinNode(root.left).data;
    }

    private Node getMinNode(Node node) {
        Node minNode = node;
        if(minNode.left != null){
            minNode = getMinNode(minNode.left);
        }
        return minNode;
    }

    public Node getNode(T data){
        Node current = new Node(data);
        if(current.compareTo(root) == 0){
            return root;
        }
        return getNode(root, current);
    }

    private Node getNode(Node node, Node current) {
        Node temp = node;
        while(temp != null && temp.compareTo(current) != 0){
            if(temp != null && current.compareTo(temp) > 0){
                temp = temp.right;
                continue;
            } else{
                temp = temp.left;
            }
            if(temp == null) return null;
        }
        return temp;
    }

    public void deleteNode(T data){
        Node temp = new Node(data);
        Node parent = root;
        Node current = root;
        boolean isLeftNode = true;
        while(current != null && current.compareTo(temp) != 0){
            parent = current;
            if(current != null && current.compareTo(temp) > 0){
                isLeftNode = true;
                current = current.left;
            } else{
                isLeftNode = false;
                current = current.right;
            }
        }
        if(current == null) return;
        if(current.left == null && current.right == null){
            if(current.compareTo(root) == 0) {
                root = null;
            } else if(isLeftNode){
                parent.left = null;
            } else{
                parent.right = null;
            }
        } else if(current.left == null){
            if(current.compareTo(root) == 0) {
                root = current.left;
            } else if(isLeftNode){
                parent.left = current.right;
            } else{
                parent.right = current.right;
            }
        } else if(current.right == null){
            if(current.compareTo(root) == 0){
                root = current.right;
            } else if(isLeftNode){
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else{
            Node suitableNode = findMostLeftNodeOfRightNode(current);
            if(current.compareTo(root) == 0){
                root = suitableNode;
            } else if(isLeftNode){
                parent.left = suitableNode;
            } else{
                parent.right = suitableNode;
            }
            suitableNode.left = current.left;
        }
    }

    private Node findMostLeftNodeOfRightNode(Node node) {
        Node parent = node;
        Node suitableNode = node;
        Node current = node.right;
        while(current != null){
            parent = suitableNode;
            suitableNode = current;
            current = current.left;
        }
        if(suitableNode.compareTo(node.right) != 0){
            parent.left = suitableNode.right;
            suitableNode.right = node.right;
        }
        return suitableNode;
    }

    public void mirror(Node node){
        if(node != null){
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            mirror(node.left);
            mirror(node.right);
        }
    }

    class Node<E extends Comparable<E>> implements Comparable<Node>{
        E data;
        Node left;
        Node right;
        Node(){}
        Node(E data){
            this.data = data;
        }


        @Override
        public int compareTo(Node o) {
            return data.compareTo((E) o.data);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(5);
        tree.addNode(2);
        tree.addNode(4);
        tree.addNode(1);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(3);

        System.out.println("in order");
        tree.inOrderTraverse(tree.root);
        System.out.println();
        System.out.println("pre order");
        tree.preOrderTraverse(tree.root);
        System.out.println();
        System.out.println("post order");
        tree.postOrderTraverse(tree.root);
        System.out.println();
        System.out.println("level order");
        tree.breadthFirstTraverse(tree.root);
        System.out.println();
        System.out.println("dfs order");
        tree.depthFirstTraverse(tree.root);
        System.out.println();
        System.out.println("do mirror");
        tree.mirror(tree.root);
        System.out.println();
        System.out.println("level order");
        tree.breadthFirstTraverse(tree.root);
        System.out.println();
        System.out.println("do mirror");
        tree.mirror(tree.root);

        System.out.println("max is " + tree.getMax());

        System.out.println("min is " + tree.getMin());

        System.out.println(tree.getNode(2).data);
        System.out.println(tree.getNode(2).left.data);
        System.out.println(tree.getNode(2).right.data);

        tree.deleteNode(4);
        System.out.println("level order");
        tree.breadthFirstTraverse(tree.root);

    }
}
