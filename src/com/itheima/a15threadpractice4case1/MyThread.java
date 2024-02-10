package com.itheima.a15threadpractice4case1;

import java.util.Random;

public class MyThread extends Thread {
    /**
     * 抢红包也用到了多线程
     * 假设：100块，分成了3个包，现在有5个人去抢
     * 其中，红包是共享数据
     * 5个人是5条线程
     * 打印结果如下：
     * XXX抢到了XXX元
     * XXX抢到了XXX元
     * XXX抢到了XXX元
     * XXX没抢到
     * XXX没抢到
     */
    //共享数据
    //100块，分成3个红包
    static double money = 100;
    static int count = 3;
    //最小的中奖金额
    static final double MIN = 0.01;

    @Override
    public void run() {
        //因为每个人抢一次，所以无需循环
        //同步代码块
        synchronized (MyThread.class) {
            if (count == 0) {
                //判断，共享数据是否到了末尾（已经到末尾）
                System.out.println(getName() + "没有抢到红包");
            } else {
                //判断，共享数据是否到了末尾（没有到末尾）
                //定义一个变量，表示中奖的金额
                double price = 0;
                if(count == 1){
                    //表示此时是最后一个红包
                    //就无需随机，剩余所有的钱就是中奖金额
                    price = money;
                } else {
                    Random r = new Random();
                    //下面这个nextDouble是JDK17才能用的
                    //这个bounds就保证了不会有金额等于0的
                    double bounds = money - (count - 1) * MIN;
                    price = r.nextDouble(bounds);
                    //如果金额等于0的就为最小中奖金额
                    if(price < MIN) {
                        price = MIN;
                    }
                }
                //从money当中，去掉当前中奖的金额
                money -= price;
                //红包的个数-1
                count--;
                System.out.println(getName() + "抢到了" + price + "元！！！");
            }
        }

    }
}
