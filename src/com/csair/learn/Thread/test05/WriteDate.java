package com.csair.learn.Thread.test05;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 发送数据
 */
public class WriteDate {
    public void writeMethod(PipedOutputStream outputStream){
        System.out.println("write:");
        try {
            for(int i=0;i<20;i++){
                String outData = " "+(i+1);
                outputStream.write(outData.getBytes());
                //System.out.println(outData);

            }
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
