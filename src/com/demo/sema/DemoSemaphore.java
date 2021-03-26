package com.demo.sema;

import java.util.concurrent.Semaphore;

/**
 * @author Shi You Qin
 * @email secret620@163.com
 * @date Create 2021/3/26 14:42
 * @description 表示 ：
 **/
public class DemoSemaphore {
    // 以A开始的信号量,初始信号量数量为1
    private static Semaphore A = new Semaphore(1);
    // B、C信号量,A完成后开始,初始信号数量为0
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);


    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try{
                A.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.print(Thread.currentThread().getName());
//                Thread.sleep(3000);
                System.out.println("执行结束");
                B.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
            }catch (Exception e){}
        },"a");

        Thread b = new Thread(() -> {
            try{
                B.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.print(Thread.currentThread().getName());
//                Thread.sleep(1000);
                System.out.println("执行结束");
                C.release();// C释放信号，C信号量加1（初始为0），此时可以获取C信号量
            }catch (Exception e){}
        },"b");

        Thread c = new Thread(() -> {
            try{
                C.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.print(Thread.currentThread().getName());
//                Thread.sleep(5000);
                System.out.println("执行结束");
                A.release();// A释放信号，A信号量加1（初始为0），此时可以获取A信号量
            }catch (Exception e){}
        },"c");

        a.start();
        b.start();
        c.start();
    }
}
