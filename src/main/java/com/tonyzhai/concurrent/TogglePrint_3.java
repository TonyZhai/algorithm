package com.tonyzhai.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * 有两个线程：
 * 第一个线程打印”123456“
 * 第二个线程打印“abcdef“
 * 
 * 但是需要交替打印，以上边为例，结果是“1a2b3c4d5e6f”
 * 
 */
public class TogglePrint_3 {
    
    String str1 = "123456";
    String str2 = "abcdef";

    Thread t1;
    Thread t2;

    CountDownLatch c1 = new CountDownLatch(1);
    CountDownLatch c2 = new CountDownLatch(1);
    
    public void togglePrint () {
        t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (char c : str1.toCharArray()) {
                    System.out.println(c);
                    c2.countDown();
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
            }
            
        });

        t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (char c : str2.toCharArray()) {
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(c);
                    c1.countDown();
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
