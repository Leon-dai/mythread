package com.itheima.a15threadpractice1;

public class MyThread extends Thread{
    /**
     * 1.循环
     * 2.同步代码块
     * 3.判断
     * 4.判断
     */
    static int ticket = 1000;
    @Override
    public void run() {
        while(true){
            synchronized (MyThread.class){
                if(ticket == 0){
                    System.out.println("票已卖完");
                    break;
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(getName() + "卖出去一张票，还剩" + ticket + "张票");
                }
            }
        }
    }
}
