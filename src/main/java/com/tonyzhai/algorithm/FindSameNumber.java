package com.tonyzhai.algorithm;

public class FindSameNumber {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,8,90,99};
        int[] b = {1,3,4,6,9,10,90,100};
        String sameStr = findSameNumber(a,b);
        System.out.println("result is " + sameStr);
    }


    private static String findSameNumber(int[] a,int[] b){
        int aMax = a[a.length-1];
        int bMax = b[b.length-1];
        int sameArrLength = 0;

        String sameStr = "";
        if (aMax > bMax) {
            sameArrLength = aMax+1;
        }else{
            sameArrLength = bMax+1;
        }
        int[] sameArr = new int[sameArrLength];

        for (int i = 0; i < a.length; i++) {
            sameArr[a[i]] = 1;
        }

        for (int i = 0; i < b.length; i++) {

            if (sameArr[b[i]] == 1) {
                sameStr += b[i]+",";
            }
        }
        return sameStr;
    }
}