package com.itheima.a15threadpractice3;



public class ThreadDemo {
    public static void main(String[] args) {
        //1.获取参数对象
        MyRunable mr = new MyRunable();

        //2.获取线程对象
        Thread t1 = new Thread(mr, "线程1");
        Thread t2 = new Thread(mr, "线程2");

        //3.开启线程
        t1.start();
        t2.start();
    }
}
