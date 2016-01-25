package com.tonyzhai.algorithm;


import java.util.ArrayList;

/**
 * ??????
 * 		????????????????? 
 *
 * ??
 * 		????????????? 
 * 		????????????????????????????????? 
 * 		????????????????? 
 * 		??????22 ?????? 
 * 		10 
 * 		/ \ 
 * 		5 12 
 * 		/\ 
 * 	    4 7 
 * 		?????????10, 12 ?10, 5, 7
 *
 * ??
 * 		????????????????????????????????????????????????
 *      ??????????????????????
 *      ?????
 *
 * @author tony
 *
 */
public class BinaryTreeAllPathAgainstSpecifiedSum {
    private Node root;
    class Node{
        private int data;
        private Node left;
        private Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public void buildTree(){
        addNode(10, root);
        addNode(5, root);
        addNode(12, root);
        addNode(4, root);
        addNode(7, root);

    }

    /**
     * ????????
     *
     * @param data
     */
    public void addNode(int data) {
        if (null == this.root) {
            this.root = new Node(data);
            return;
        }
        Node tempNode = this.root;
        while (true) {
            if (data > tempNode.data) {
                if (null == tempNode.right) {
                    tempNode.right = new Node(data);
                    return;
                } else {
                    tempNode = tempNode.right;
                    continue;
                }
            } else if (data < tempNode.data) {
                if (null == tempNode.left) {
                    tempNode.left = new Node(data);
                    return;
                } else {
                    tempNode = tempNode.left;
                    continue;
                }
            } else {
                return;
            }
        }
    }

    /**
     * ????????
     *
     * @param data
     * @param tempNode
     */
    public void addNode(int data, Node tempNode) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        if (data >= tempNode.data) {
            if (tempNode.right == null) {
                tempNode.right = new Node(data);
                return;
            } else {
                addNode(data, tempNode.right);
            }
        } else {
            if (tempNode.left == null) {
                tempNode.left = new Node(data);
                return;
            } else {
                addNode(data, tempNode.left);
            }
        }
    }

    public void getAllPath(int sum){
        getAllPath(root, new ArrayList<Integer>(), 0, sum);
    }

    public void getAllPath(Node node, ArrayList<Integer> list, int currentSum, int sum){
        if(node != null){
            list.add(node.data);
            currentSum += node.data;
            if((node.left == null && node.right == null) && sum == currentSum){
                for(int i = 0; i < list.size(); i++){
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
            getAllPath(node.left, list, currentSum, sum);
            getAllPath(node.right, list, currentSum, sum);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        BinaryTreeAllPathAgainstSpecifiedSum tree = new BinaryTreeAllPathAgainstSpecifiedSum();
        tree.buildTree();
        tree.getAllPath(22);
    }
}
