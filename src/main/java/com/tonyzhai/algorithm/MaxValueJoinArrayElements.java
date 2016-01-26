package com.tonyzhai.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValueJoinArrayElements {
	public static void getMaxValue(String[] array){
		Arrays.sort(array, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int maxLength = Math.max(o1.length(), o2.length());
				if(o1.length() > o2.length()){
					while(o2.length() != o1.length()){
						o2 += o2.charAt(o2.length() - 1);
					}
				} else {
					while(o2.length() != o1.length()){
						o1 += o1.charAt(o1.length() - 1);
					}
				}
				for(int i = 0; i < maxLength; i++){
					if(o1.charAt(i) > o2.charAt(i)){
						return -1;
					}
					if(o1.charAt(i) < o2.charAt(i)){
						return 1;
					}
				}
				return 0;
			}
		});
	}
	
	public static void main(String[] args){
		String[] array = new String[]{"11", "1120", "101", "99", "990", "909"};
		getMaxValue(array);
		for(String str : array){
			System.out.print(str + " ");
			
		}
	}
}
