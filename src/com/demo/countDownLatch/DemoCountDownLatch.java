package com.demo.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Shi You Qin
 * @description 表示 ：
 * @email secret620@163.com
 * @date Create 2021/3/26 15:57
 **/
public class DemoCountDownLatch {
    /**
     * 计数器，用来控制线程
     * 传入参数3，表示计数器计数为3
     */
    private final static CountDownLatch countDownLatch_a = new CountDownLatch(0);
    private final static CountDownLatch countDownLatch_b = new CountDownLatch(1);
    private final static CountDownLatch countDownLatch_c = new CountDownLatch(1);

    public static void main(String[] args)  {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    countDownLatch_a.await();
                    Thread.sleep(3000);
                    System.out.print("a");
                    System.out.println("执行结束");
                }catch (Exception e){}
                countDownLatch_b.countDown();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    countDownLatch_b.await();
                    Thread.sleep(5000);
                    System.out.print("b");
                    System.out.println("执行结束");
                }catch (Exception e){}
                countDownLatch_c.countDown();
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    countDownLatch_c.await();
                    Thread.sleep(2000);
                    System.out.print("c");
                    System.out.println("执行结束");
                }catch (Exception e){}
            }
        });

        a.start();
        c.start();
        b.start();

    }
}
