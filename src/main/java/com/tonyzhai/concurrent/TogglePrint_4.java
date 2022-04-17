package com.tonyzhai.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 有两个线程：
 * 第一个线程打印”123456“
 * 第二个线程打印“abcdef“
 * 
 * 但是需要交替打印，以上边为例，结果是“1a2b3c4d5e6f”
 * 
 */
public class TogglePrint_4 {
    
    String str1 = "123456";
    String str2 = "abcdef";

    Thread t1;
    Thread t2;

    public void togglePrint () {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try {
                    for (char c : str1.toCharArray()) {
                        System.out.println(c);
                        c2.signal();
                        try {
                            c1.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    //TODO: handle exception
                } finally {
                    lock.unlock();
                }
                
                
            }
            
        });

        t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try {
                    for (char c : str2.toCharArray()) {
                        try {
                            c2.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println(c);
                        c1.signal();
                    }
                } catch (Exception e) {
                    //TODO: handle exception
                } finally {
                    lock.unlock();
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
