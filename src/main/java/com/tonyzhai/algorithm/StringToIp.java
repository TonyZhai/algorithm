package com.tonyzhai.algorithm;

public class StringToIp {
	
	public static void stringToIp(String seq){
		stringToIp(seq, 1, "");
	}

	private static void stringToIp(String str, int count, String ip) {
		if(count == 4 && checkBound(str)){
			System.out.println(ip + "." + str);
		}
		for(int i = 1; i <= str.length(); i++){
			if(checkBound(str.substring(0, i))){
				stringToIp(str.substring(i), count + 1, ip + (ip.length() == 0 ? ip : ".") + str.substring(0, i));
			}
		}
		
	}

	private static boolean checkBound(String str) {
		if(str.length() == 0){
			return false;
		}
		if(str.length() < 3){
			return true;
		}
		return str.length() <=3 && str.compareTo(String.valueOf(255)) < 0 && str.compareTo(String.valueOf(0)) >= 0;
	}
	
	public static void main(String[] args){
		String str1 = "123456733";
		stringToIp(str1);
	}
}
