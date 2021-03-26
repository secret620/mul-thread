package com.demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shi You Qin
 * @description 表示 ：
 * @email secret620@163.com
 * @date Create 2021/3/26 15:16
 **/
public class DemoLock {
    private static int count = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();
    final private static Condition A = reentrantLock.newCondition();
    final private static Condition B = reentrantLock.newCondition();
    final private static Condition C = reentrantLock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.print("a");
                    System.out.print(" count="+(count % 3));
                    Thread.sleep(5000);
                    while (count % 3 != 0){
                        A.await(); // 会释放lock锁
                    }
                    count++;
                    B.signal(); // 唤醒相应线程
                    System.out.print(" count="+count);
                    System.out.println("执行结束");
                }catch (Exception e){e.printStackTrace();} finally {
                    reentrantLock.unlock();
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.print("b");
                    System.out.print(" count="+count);
                    Thread.sleep(1000);
                    while (count % 3 != 1){
                        B.await(); // 会释放lock锁
                    }
                    count++;
                    C.signal(); // 唤醒相应线程
                    System.out.print(" count="+count);
                    System.out.println("执行结束");
                }catch (Exception e){e.printStackTrace();} finally {
                    reentrantLock.unlock();
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try{
                    System.out.print("c");
                    System.out.print(" count="+count);
                    Thread.sleep(3000);
                    while (count % 3 != 2){
                        C.await(); // 会释放lock锁
                    }
                    count++;
                    A.signal(); // 唤醒相应线程
                    System.out.print(" count="+count);
                    System.out.println("执行结束");
                }catch (Exception e){e.printStackTrace();} finally {
                    reentrantLock.unlock();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }
}
