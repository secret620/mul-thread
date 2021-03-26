package com.demo.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Shi You Qin
 * @description 表示 ：还有点问题
 * @email secret620@163.com
 * @date Create 2021/3/26 17:00
 **/
public class DemoCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("CyclicBarrier的线程");
            }
        });

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a开始");
                try{
                    Thread.sleep(3000);
                    System.out.println("a执行结束");
                    cyclicBarrier.await();
                    System.out.print("  a解锁");
                }catch (Exception e){}
            }
        },"a");

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("b开始");
                try{
                    Thread.sleep(5000);
                    System.out.println("b执行结束");
                    cyclicBarrier.await();
                    System.out.print("  b解锁");
                }catch (Exception e){}
            }
        },"b");

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("c开始");
                try{
                    Thread.sleep(2000);
                    System.out.println("c执行结束");
                    cyclicBarrier.await();
                    System.out.print("  c解锁");
                }catch (Exception e){}
            }
        },"c");

        a.start();
        c.start();
        b.start();

    }
}
