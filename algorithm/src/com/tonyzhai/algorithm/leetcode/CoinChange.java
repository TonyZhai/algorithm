package com.tonyzhai.algorithm.leetcode;

/**
 ????
 ?????????????????????????????????????????????????????
 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        if(coins == null || coins.length == 0){
            return -1;
        }
        if(coins.length == 1 && coins[0] > 0){
            int value = coins[0];
            if(amount % value == 0)
                return amount/value;
        }
        int[] temp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            temp[i] = -1;
        }
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){ if(j >= coins[i] && temp[j - coins[i]] != -1){
                if(temp[j] == 0 || temp[j] == -1){
                    temp[j] = temp[j - coins[i]] + 1;
                } else{
                    temp[j] = Math.min(temp[j], temp[j - coins[i]] + 1);
                }
            }
            }
        }
        return temp[amount];
    }
}
