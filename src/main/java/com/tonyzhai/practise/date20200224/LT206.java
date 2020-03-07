package com.tonyzhai.practise.date20200224;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LT206 {

    public ListNode reverseList(ListNode head) {
        return recursion(head, null);
    }

    private ListNode recursion(ListNode node, ListNode previous) {
        // Terminator
        if (node == null) {
            return previous;
        }

        // Current level logic
        ListNode next = node.next;
        node.next = previous;

        // Drill down
        return recursion(next, node);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode head = new LT206().reverseList(node1);
        System.out.println(head);
    }
}

//Definition for singly-linked list.
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
