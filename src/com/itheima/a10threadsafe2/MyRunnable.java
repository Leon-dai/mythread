package com.itheima.a10threadsafe2;

public class MyRunnable implements Runnable{

    int ticket = 0;

    @Override
    public void run() {
        //1.循环
        while(true){
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        //3.判断共享数据是否到了末尾
        if(ticket == 100){
            return true;
        } else {
            ticket++;
            System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票！！！");
        }
        return false;
    }
}
