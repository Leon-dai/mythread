package com.itheima.a16threadpool1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        /**
         * public static ExecutorService newCachedThreadPool()创建一个没有上限的线程池
         * public static ExecutorService newFixedThreadPool（int nThreads）创建有上限的线程池
         *线程池主要核心原理
         * ①创建一个池子，池子中是空的
         * ②提交任务时，池子会创建新的线程对象，任务执行完毕，线程归还给池子
         * 下回再次提交任务时，不需要创建新的线程，直接复用已有的线程即可
         * ③但是如果提交任务时，池子中没有空闲线程，也无法创建新的线程，任务就会排队等待
         */
        //1.获取线程池对象
        ExecutorService pool1 = Executors.newFixedThreadPool(3);

        //2.提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        //3.销毁线程池
//        pool1.shutdown();


    }
}
