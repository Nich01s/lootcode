package com.leetcode.test;

/**
 * @Author: Nic1
 * @Date: 2022/7/4 12:25
 * @Theme:
 */
public class ThreadState {
    public static void main(String[] args) {

        new Thread(new TimeWaiting(), "TimeWaitingThread").start();//启动线程1
        new Thread(new Waiting(), "WaitingThread").start();//启动线程2
        new Thread(new Blocked(), "BlockedThread-1").start();//启动Blocked1线程
        new Thread(new Blocked(), "BlockedThread-2").start();//启动Blocked2线程
    }

    //线程1：该线程不断地进行睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //线程2：该线程在Waiting.class锁上等待
    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //线程3：该线程在Blocked.class实例上加锁后，不会释放该锁
    static class Blocked implements Runnable{
        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
