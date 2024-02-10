package com.itheima.a15threadpractice5case2;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MyThread extends Thread {
    /**
     * 抽奖池抽奖2
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
    ArrayList<Integer> list = new ArrayList<>();

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        ArrayList<Integer> boxList = new ArrayList<>();
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (com.itheima.a15threadpractice5case1.MyThread.class) {
                //判断，共享数据是否到达末尾（已到达末尾）
                if (list.size() == 0) {
                    System.out.println(getName() + boxList);
                    break;
                }
                //判断，共享数据是否到达末尾（未到达末尾）
                else {
                    //随机方式1
                    //Random r = new Random();
                    //int randomIndex = r.nextInt(list.size());
                    //int price = list.remove(randomIndex);

                    //随机方式2,使用shuffle打乱集合中的元素顺序
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    boxList.add(price);
                }
            }
            //不要写在锁里面，不然其他线程依然进不去，让结果尽可能平均一点
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
