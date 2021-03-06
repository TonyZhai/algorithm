package com.tonyzhai.algorithm;

/**
 * @author tony
 *
 */
public class BinarySearchTreeToTwoWayLinkedList {
    private Node last;
    private Node first;

    class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    /**
     * @param node
     */
    public void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            }else{
                first = node;
            }
            last = node;
            inOrderTraverse(node.right);
        }
    }

    public Node buildTree() {
        Node node1 = new Node(10);
        Node node2 = new Node(6);
        Node node3 = new Node(14);
        Node node4 = new Node(4);
        Node node5 = new Node(8);
        Node node6 = new Node(12);
        Node node7 = new Node(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public void reversePrint(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.left;
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeToTwoWayLinkedList binarySearchTreeToTwoWayLinkedList = new BinarySearchTreeToTwoWayLinkedList();
        Node node = binarySearchTreeToTwoWayLinkedList.buildTree();
        binarySearchTreeToTwoWayLinkedList.inOrderTraverse(node);
        binarySearchTreeToTwoWayLinkedList.print(binarySearchTreeToTwoWayLinkedList.first);
        System.out.println();
        binarySearchTreeToTwoWayLinkedList.reversePrint(binarySearchTreeToTwoWayLinkedList.last);
    }
}
