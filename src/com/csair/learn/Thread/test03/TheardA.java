package com.csair.learn.Thread.test03;

/**
 * Created by mac on 17/1/3.
 */
public class TheardA extends  Thread{
    private Object lock;

    public TheardA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            synchronized (lock){
                if(MyList.size()!=5){
                    System.out.println("线程"+Thread.currentThread().getName()+"wait begin"+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("线程"+Thread.currentThread().getName()+"wait end"+System.currentTimeMillis());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
