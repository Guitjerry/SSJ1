package com.csair.learn.Thread.test02;

/**
 * Created by mac on 16/12/29.
 */
public class CountOperate extends Thread{
    public CountOperate() {
        System.out.println("CountOperate --- begin");
        System.out.println("当前线程名称="+Thread.currentThread().getName());
        System.out.println("是否是活动的线程"+Thread.currentThread().isAlive());
        System.out.println("this.getname="+this.getName());
        System.out.println("this.alive="+this.isAlive());
        System.out.println("CountOperate --- end");
    }
}
