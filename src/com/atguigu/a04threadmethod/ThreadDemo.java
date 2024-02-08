package com.atguigu.a04threadmethod;

public class ThreadDemo {
    public static void main(String[] args) {
        //1.创建线程的对象
        MyThread t1 = new MyThread("飞机");
        MyThread t2 = new MyThread("坦克");

        t1.setPriority(1);
        t2.setPriority(10);
        //开启线程
        t1.start();
        t2.start();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}
