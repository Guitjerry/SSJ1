package com.csair.learn.Thread.test02;

/**
 * Created by mac on 16/12/29.
 */
public class Run {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread thread1 = new Thread(c);
        System.out.println("main begin t1 isAlive="+thread1.isAlive());
        thread1.setName("A");
        thread1.start();
        System.out.println("main end t1 isAlive="+thread1.isAlive());
    }
}
