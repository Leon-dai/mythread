package com.itheima.a09threadsafe1;

public class MyThread extends Thread{

    static int ticket = 0;//0~99

    //锁对象，一定要是唯一的
//    static Object obj = new Object();

    @Override
    public void run() {
        while(true){
            //同步代码块
            synchronized (MyThread.class){//锁对象可以是任意的对象，只要是唯一的就行
                if(ticket < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}
