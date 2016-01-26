package com.tonyzhai.algorithm;

/**
 * two array has already sorted, find them intersection
 *
 * @author tony
 */
public class FindTwoArrayIntersetion {
    public static void findTwoInterSection(int[] arrayOne, int[] arrayTwo){
        int maxValue = Math.max(arrayOne[arrayOne.length - 1], arrayTwo[arrayTwo.length - 1]);
        int[] tempArray = new int[maxValue + 1];
        for(int i = 0; i < arrayOne.length; i++){
            tempArray[arrayOne[i]] = 1;
        }
        for(int i = 0; i < arrayTwo.length; i++){
            if(tempArray[arrayTwo[i]] == 1){
                System.out.print(arrayTwo[i] + " ");
            }
        }
    }

    public static void main(String[] args){
        int[] arrayOne = {1, 3, 12, 19, 20, 99, 128, 236};
        int[] arrayTwo = {2, 9, 11, 12, 19, 128, 148, 239, 349};
        findTwoInterSection(arrayOne, arrayTwo);
    }
}
