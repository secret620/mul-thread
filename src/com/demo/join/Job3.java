package com.demo.join;

/**
 * @author Shi You Qin
 * @email secret620@163.com
 * @date Create 2021/3/26 10:31
 * @deprecated 表示 ：
 **/
public class Job3 implements Runnable{
    Thread thread_2;

    public Job3(Thread thread_2){
        this.thread_2 = thread_2;
    }
    @Override
    public void run() {
        try {
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("job3");
    }
}
