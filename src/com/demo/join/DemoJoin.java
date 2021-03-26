package com.demo.join;

/**
 * @author Shi You Qin
 * @email secret620@163.com
 * @date Create 2021/3/26 10:30
 * @description 表示 ：
 **/
public class DemoJoin {
    public static void main(String[] args) {
        Thread thread_1 = new Thread(new Job("Job1"));
        Thread thread_2 = new Thread(new Job("Job2", thread_1));
        Thread thread_3 = new Thread(new Job("Job3", thread_2));
        thread_1.start();
        thread_2.start();
        thread_3.start();


    }
}
