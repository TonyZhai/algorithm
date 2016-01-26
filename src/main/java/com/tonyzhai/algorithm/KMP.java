package com.tonyzhai.algorithm;

/**
 * @author tony
 *
 */
public class KMP {
    private static int[] getNextArray(String target){
        int[] nextArray = new int[target.length()];
        int i = -1;
        int j = 0;
        while(j < target.length() - 1){
            if(i == -1 || target.charAt(i) == target.charAt(j)){
                i++;
                j++;
                if(target.charAt(i) != target.charAt(j)){
                    nextArray[j] = i + 1;
                }else{
                    nextArray[j] = nextArray[j] + 1;
                }
            } else{
                i = nextArray[i] - 1;
            }
        }
        return nextArray;
    }

    public static int getIndex(String origin, String target){
        int[] nextArray = getNextArray(target);
        int i = 0;
        int j = 0;
        while (i <= origin.length() - 1 && j <= target.length() - 1) {
            if (j == -1 || origin.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextArray[j] - 1;
            }
        }
        return j == target.length() ? i - target.length() : -1;
    }


    public static void main(String[] args){
        String origin = "adadsasdababaaabababaaabaabaaaba";
        String target = "ababaaaba";
        for(int i = 0; i < origin.length(); i ++){
            System.out.print(origin.charAt(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < target.length(); i ++){
            System.out.print(target.charAt(i) + " ");
        }
        int[] nextArray = getNextArray(target);
        System.out.println();
        for(int i : nextArray){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(getIndex(origin, target));
    }
}