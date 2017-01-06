package com.csair.learn.Thread.test05;

import java.io.PipedOutputStream;

/**
 * Created by mac on 17/1/4.
 */
public class ThreadWrite extends Thread{
   private WriteDate writeDate;
   private PipedOutputStream out;

    public ThreadWrite(WriteDate writeDate, PipedOutputStream out) {
        this.writeDate = writeDate;
        this.out = out;
    }

    @Override
    public void run() {
        writeDate.writeMethod(out);
    }
}
