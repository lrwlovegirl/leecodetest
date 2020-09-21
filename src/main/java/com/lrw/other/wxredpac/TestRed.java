package com.lrw.other.wxredpac;

import java.util.Random;

/**
 * 红包的额度： 0.01 -- 剩余平均值*2
 */
public class TestRed {
    private static RedPackage redPackage = new RedPackage();
    //初始化函数
    static void init() {
        redPackage.setMoney(500);
        redPackage.setSize(20);
    }
    //获取每一次抢到的红包金额
    public static double getRandomMoney(RedPackage redPackage) {
        //红包只有一个或只剩下一个
        if(redPackage.getSize() == 1) {
            redPackage.setSize(redPackage.getSize()-1);
            return (double)Math.round(redPackage.getMoney() * 100)/100;    //取整 四舍五入
        }
        Random r = new Random();
        //规定最少抢到的红包有0.01元，最多为剩余的红包钱的平均值*2
        double min = 0.01;
        double max = redPackage.getMoney() / redPackage.getSize() * 2;
        double money = r.nextDouble() * max;        //nextDouble返回0.0~1.0之间的数
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;         //取整 不大于这个数的最大整数
        redPackage.setSize(redPackage.getSize()-1);
        redPackage.setMoney((int) (redPackage.getMoney()-money));
        return money;
    }

    public static void main(String[] args) {
        //初始化
        init();
        int size = redPackage.getSize();
        for(int j=1; j<=2; j++) {
            System.out.println("第"+j+"轮");
            for(int i=1; i<=size; i++) {
                double single = getRandomMoney(redPackage);
//                System.out.println("第"+ i + "个红包："+ single);
                System.out.print(single + "   ");
            }
            System.out.println("");
            init();
        }
    }
}
