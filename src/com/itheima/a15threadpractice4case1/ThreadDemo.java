package com.itheima.a15threadpractice4case1;

public class ThreadDemo {
    public static void main(String[] args) {
        //1.创建线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        //2.给线程起名字 可用Alt+鼠标左键进行竖着选中
        t1.setName("a");
        t2.setName("b");
        t3.setName("c");
        t4.setName("d");
        t5.setName("e");

        //3.启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
