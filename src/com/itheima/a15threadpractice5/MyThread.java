package com.itheima.a15threadpractice5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MyThread extends Thread {
    /**
     * 抽奖池抽奖
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
    ArrayList<Integer> list = new ArrayList<>();

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (MyThread.class) {
                //判断，共享数据是否到达末尾（已到达末尾）
                if (list.size() == 0) {
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
                    System.out.println(getName() + "又产生一个" + price + "元大奖");
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
