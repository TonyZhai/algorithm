package com.tonyzhai.leetcode;

/*
 Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example:
 For num = 5 you should return [0,1,1,2,1,2].

 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

 这应该是一道新放入的题。意思是给你一个非负整数num，对于0到num这(num+1)个整数，求出每个数用二进制表示时1的个数。

最简单的思路：对每个数，利用移位和按位与（i & 1）运算，计算1的个数。这样时间复杂度为O(n*sizeof(integer))，如果int用32位表示，那么时间复杂度就是O(32n)。

考虑优化成O(n)：

对于11这个数，我们暂时用一个字节来表示

11：           0000 1011

11/2 = 5：0000 0101

容易发现，除了11最右边那个位和5的最高位，其他位对应一样。也就是说i用二进制表示时1出现的次数等于i/2中1出现的次数加1（如果i用二进制表示时最右边一位为1，否则不加1）。这样我们在计算i时可以利用前面已计算出的i/2：ret[i] = ret[i/2] + (i % 2 == 0 ? 0 : 1);
 */
public class LC338 {
    public static int[] countBits1(int num){
        assert num >= 0;
        int[] bits = new int[num + 1];
        for(int i = 0; i < bits.length; i++){
            int count = 0;
            for(int j = 0; j <= i; j++){
                count += (i >> j) & 1;
            }
            bits[i] = count;
        }
        return bits;
    }

    public static int[] countBits2(int num){
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {
        int[] bits1 = countBits1(5);
        for(int i : bits1){
            System.out.println(i + " ");
        }
        int[] bits2 = countBits1(5);
        for(int i : bits2){
            System.out.println(i + " ");
        }
    }
}
