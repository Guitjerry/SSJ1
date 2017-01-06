package com.csair.learn.Thread.test04;

/**
 * Created by mac on 17/1/4.
 */
public class Test {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadC threadC = new ThreadC(c);
        ThreadP threadP = new ThreadP(p);
        threadC.start();
        threadP.start();
    }
}
