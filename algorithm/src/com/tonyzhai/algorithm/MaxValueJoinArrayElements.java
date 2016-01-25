package com.tonyzhai.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValueJoinArrayElements {
	public static void getMaxValue(String[] array){
		Arrays.sort(array, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int maxLength = Math.max(o1.length(), o2.length());
				int minLength = Math.min(o1.length(), o2.length());
				for(int i = 0; i < maxLength; i++){
					if(o1.length() > o2.length() && o2.length() == minLength){
						o2+=o2.length() - 1;
					} else if(o2.length() > o1.length() && o1.length() == minLength){
						o1+=o1.length() - 1;
					}
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
		String[] array = new String[]{"11", "110", "101", "99", "990", "909"};
		getMaxValue(array);
		for(String str : array){
			System.out.print(str + " ");
			
		}
	}
}
