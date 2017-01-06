package com.csair.learn.Thread.test05;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 通过管道进行线程间的通信
 */
public class Test {
    public static void main(String[] args) {
        try{
            WriteDate writeDate= new WriteDate();
            ReadData readData = new ReadData();
            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            pipedOutputStream.connect(pipedInputStream);
            ThreadReader reader = new ThreadReader(readData,pipedInputStream);
            reader.start();
            reader.sleep(1000);
            ThreadWrite write = new ThreadWrite(writeDate,pipedOutputStream);
             write.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
