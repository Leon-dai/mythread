package com.itheima.a15threadpractice5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ThreadDemo {
    /** 抽奖池抽奖
     * 有一个抽奖池，该抽奖池中存放了奖励的金额，
     * 该抽奖池中的奖项为{10,5,20,50,100,200,500,800,2,80,300,700};
     * 创建两个抽奖箱(线程）   设置线程名称分别为“抽奖箱1"“抽奖箱2"
     * 随机从抽奖池中获取奖项元素并打印在控制台上，
     * 格式如下：每次抽出一个奖项就打印一个(随机)
     * 抽奖箱1又产生了一个10元大浆
     * 抽奖箱1又产生了一个100元大奖
     * 抽奖箱1又产生了一个200元大奖
     * 抽奖箱1又产生了一个800元大奖
     * 抽奖箱2又产生了一个700元大奖
     */
    public static void main(String[] args) {
        //1.创建奖池
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10,5,20,50,100,200,500,800,2,80,300,700);

        //2.创建线程对象
        MyThread t1 = new MyThread(list);
        MyThread t2 = new MyThread(list);

        //3.给线程设置名字
        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");

        //4.启动线程
        t1.start();
        t2.start();
    }
}
