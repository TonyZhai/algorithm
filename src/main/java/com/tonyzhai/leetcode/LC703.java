package com.tonyzhai.leetcode;

import java.util.PriorityQueue;

public class LC703 {

    int k;
    int[] nums;

    PriorityQueue<Integer> queue;

    public LC703(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        queue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        LC703 kthLargest = new LC703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
