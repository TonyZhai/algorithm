package com.tonyzhai.algorithm;

/**
 * Created by Administrator on 1/30/2016.
 */
public class StringToIP {
    public static void getIPs(String seq){
        getIPs(seq, 0, "");
    }

    private static void getIPs(String seq, int count, String ip) {
        if(count == 4){
            if(seq.length() == 0){
                System.out.println(ip);
            }
            return;
        }
        for(int i = 1; i <= seq.length(); i++){
            if(i > 3 || (count == 3 && (seq.length() > 3 || Integer.valueOf(seq) > 255))){
                break;
            }
            if(checkBound(seq.substring(0, i))){
                getIPs(seq.substring(i), count + 1, ip + (ip.length() == 0 ? ip : ".") + seq.substring(0, i));
            }
        }
    }

    private static boolean checkBound(String seq) {
        if(seq.length() > 1 && seq.startsWith("0")){
            return false;
        }
        return (seq.length() > 0 && seq.length() <= 3) && Integer.valueOf(seq) <= 255 && Integer.valueOf(seq) >= 0;
    }

    public static void main(String[] args) {
        getIPs("1101101231");
    }
}
