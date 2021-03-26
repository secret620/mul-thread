package com.demo.join;

/**
 * @author Shi You Qin
 * @email secret620@163.com
 * @date Create 2021/3/26 10:31
 * @deprecated 表示 ：
 **/
public class Job implements Runnable{
    String jobName;
    Thread thread_x;

    public Job(String jobName, Thread thread_x){
        this.jobName = jobName;
        this.thread_x = thread_x;
    }
    public Job(String jobName){
        this.jobName = jobName;
    }
    @Override
    public void run() {
        if(thread_x != null){
            try {
                thread_x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.jobName);
    }
}
