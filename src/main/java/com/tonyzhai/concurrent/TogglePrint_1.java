package com.tonyzhai.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 有两个线程：
 * 第一个线程打印”123456“
 * 第二个线程打印“abcdef“
 * 
 * 但是需要交替打印，以上边为例，结果是“1a2b3c4d5e6f”
 * 
 */
public class TogglePrint_1 {
    
    String str1 = "123456";
    String str2 = "abcdef";

    Thread t1;
    Thread t2;

    public void togglePrint () {
        t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (char c : str1.toCharArray()) {
                    System.out.println(c);
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
                
            }
            
        });

        t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (char c : str2.toCharArray()) {
                    LockSupport.park();
                    System.out.println(c);
                    LockSupport.unpark(t1);
                }
                
            }
            
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new TogglePrint_1().togglePrint();
    }
}
