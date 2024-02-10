package com.itheima.a15threadpractice2;

public class ThreadDemo {
    public static void main(String[] args) {

        //1.创建参数对象
        MyRunable mr = new MyRunable();

        //2.创建线程对象
        Thread t1 = new Thread(mr, "张三");
        Thread t2 = new Thread(mr, "李四");

        //3.启动线程
        t1.start();
        t2.start();

    }
}
