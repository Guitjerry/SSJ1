package com.csair.learn.Thread.test04;

/**
 * Created by mac on 17/1/4.
 */
public class ThreadC extends Thread{
    private C r;

    public ThreadC(C r) {
        super();
        this.r = r;
    }

    @Override
    public void run() {
        while (true){
            r.getValue();
        }
    }
}
