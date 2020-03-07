package com.tonyzhai.algorithm;

public class ReturnDefangedIP {

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String IP ="1.1.1.1";
        System.out.println(ReturnDefangedIP.defangIPaddr(IP));
    }
}
