package com.itheima.a15threadpractice3;

public class MyRunable implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while(true){
            synchronized (MyRunable.class){
                if(num > 100){
                    break;
                } else {
                    if(num % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + "获取到了数字" + num);
                    }
                    num++;
                }
            }
        }
    }
}
