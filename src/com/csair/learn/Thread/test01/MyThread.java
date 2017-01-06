package com.csair.learn.Thread.test01;


/**
 * Created by mac on 16/12/29.
 */
public class MyThread extends Thread {
    private int count=5;

    @Override
    public  void run() {
        super.run();
        count--;
        System.out.println("由线程"+Thread.currentThread().getName()+"计算count="+count);
    }
}
