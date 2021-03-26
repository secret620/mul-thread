package com.demo.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Shi You Qin
 * @email secret620@163.com
 * @date Create 2021/3/26 14:55
 * @description 表示 ：
 **/
public class DemoExecutors {
    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.print("a");
                    Thread.sleep(5000);
                    System.out.println("执行结束");
                }catch (Exception e){}
            }
        },"a");

        Thread b = new Thread(() -> {
            try{
                System.out.print("b");
                Thread.sleep(2000);
                System.out.println("执行结束");
            }catch (Exception e){}
        },"b");

        Thread c = new Thread(() -> {
            try{
                System.out.print("c");
                Thread.sleep(1000);
                System.out.println("执行结束");
            }catch (Exception e){}
        },"c");

        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);

        // 关闭
        executorService.shutdown();
    }
}
