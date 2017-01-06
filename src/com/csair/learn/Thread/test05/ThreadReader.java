package com.csair.learn.Thread.test05;

import java.io.PipedInputStream;

/**
 * Created by mac on 17/1/4.
 */
public class ThreadReader extends Thread{
    private ReadData readData;
    private PipedInputStream inputStream;

    public ThreadReader(ReadData readData, PipedInputStream inputStream) {
        super();
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        readData.readMethod(inputStream);
    }
}
