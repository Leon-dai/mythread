package com.itheima.a15threadpractice5case3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {
    /** 抽奖池抽奖2
     * 有一个抽奖池，该抽奖池中存放了奖励的金额，
     * 该抽奖池中的奖项为{10,5,20,50,100,200,500,800,2,80,300,700};
     * 创建两个抽奖箱(线程）   设置线程名称分别为“抽奖箱1"“抽奖箱2"
     * 在上一题基础上继续完成如下需求：每次抽的过程中，不打印，
     * 抽完时一次性打印(随机)
     * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项。分别为：10,20，100,500，2,300
     * 最高奖项为300元，总计额为932元
     * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项。分别为：5,50，200，800，80，700
     * 最高奖项为800元，总计额为1835元
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.创建奖池
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,20,50,100,200,500,800,2,80,300,700);

        //创建多线程要运行的参数对象
        MyCallable mc = new MyCallable(list);

        //创建多线程运行结果的管理者对象
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        FutureTask<Integer> ft2 = new FutureTask<>(mc);

        //创建线程
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);

        //设置名字
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        //开启线程
        t1.start();
        t2.start();

        Integer max1 = ft1.get();
        Integer max2 = ft2.get();

        System.out.println(max1);
        System.out.println(max2);
    }
}

