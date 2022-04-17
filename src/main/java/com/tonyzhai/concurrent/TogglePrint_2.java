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
public class TogglePrint_2 {

    String str1 = "123456";
    String str2 = "abcdef";

    Thread t1;
    Thread t2;

    public void togglePrint() {
        Object o = new Object();
        t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (o) {
                    for (char c : str1.toCharArray()) {
                        System.out.println(c);
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            }

        });

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (char c : str2.toCharArray()) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(c);
                        o.notify();
                    }
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
