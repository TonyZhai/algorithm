package com.tonyzhai.algorithm;

/**
 * find the first char which not repeat appear, for example: input string is "adabddeecff", result is 'b' 
 *
 * @author tony
 */
public class FindFirstNotRepeatChar {

    public static Character findFirstNotRepeatChar(String str){
        int appearTimesMarkArray[] = new int[26];
        int indexMarkArray[] = new int[appearTimesMarkArray.length];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            appearTimesMarkArray[index]++;
            indexMarkArray[index] = i;
        }
        int min = str.length();
        int k = 0;
        for (int i = 0; i < appearTimesMarkArray.length; i++) {
            if(appearTimesMarkArray[i] == 1 && indexMarkArray[i] < min) {
                min = indexMarkArray[i];
                k = i;
            }
        }
        return (char)(k + 'a');
    }
    public static void main(String[] args) {
        Character result = findFirstNotRepeatChar("agaabbbcccsdddefffg");
        if(result == null){
            System.out.println("cannot find char which not repeated");
        }else{
            System.out.println("the first char which not repeated is '" + result + "'");
        }

    }

}