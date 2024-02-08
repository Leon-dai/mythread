package com.itheima.a10threadsafe2;

public class ThreadDemo {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
        /*
        关于StringBuilder和StringBuffer，StringBuilder是
        线程不安全的，StringBuffer是线程安全的，如果只在单线程下使用
        可以使用StringBuilder，否则用StringBuffer
         */
    }
}
