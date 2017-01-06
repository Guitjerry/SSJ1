package com.csair.learn.Thread.test03;

/**
 * 等待通知机制实现线程间的通信
 */
public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        TheardA theardA = new TheardA(myList);
        theardA.setName("A");
        theardA.start();

        ThreadB threadB = new ThreadB(myList);
        threadB.setName("B");
        threadB.start();
    }
}
