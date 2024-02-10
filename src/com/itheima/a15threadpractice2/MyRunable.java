package com.itheima.a15threadpractice2;

public class MyRunable implements Runnable{
    //第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
    int gift = 100;
    @Override
    public void run() {
        /**
         * 有100份礼品，两人同时发送，
         * 当剩下的礼品小于10份的时候则不再送出。
         * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来
         */
        while(true){
            synchronized (MyRunable.class){
                if(gift < 10){
                    System.out.println("礼物已经送完");
                    break;
                } else {
                    gift--;
                    System.out.println(Thread.currentThread().getName() + "送出了一份礼物" + "，礼物还剩" + gift + "个！！！");
                }
            }
        }

    }
}
