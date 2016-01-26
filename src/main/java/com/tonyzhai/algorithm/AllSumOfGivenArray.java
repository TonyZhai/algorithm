package com.tonyzhai.algorithm;
import java.util.*;
/**
 * Created by Administrator on 1/25/2016.
 */
public class AllSumOfGivenArray {
    public static void f1(int[] input, int sum){
        Map<Integer, Boolean> history = new HashMap<Integer, Boolean>();
        Arrays.sort(input);
        history.put(input[0], true);
        for(int i = 1; i < input.length; i++){
            List<Integer> matchIndex = new ArrayList<Integer>();
            for(int j = input[i]; j <= sum; j++){
                if(input[i] > j){
                    continue;
                }
                else if(input[i] == j){
                    matchIndex.add(j);
                } else{
                    if(history.get(j - input[i]) != null &&  history.get(j - input[i]) == true){
                        matchIndex.add(j);
                    }
                }

            }
            for(int k : matchIndex){
                history.put(k, true);
            }
        }
        for(int i : history.keySet()){
            System.out.print(i + ", ");
        }
    }
    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 5, 7};
        f1(input, 14);
    }
}
