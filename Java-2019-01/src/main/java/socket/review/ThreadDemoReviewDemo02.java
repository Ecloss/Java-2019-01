package socket.review;

import java.io.IOException;

/**
 * 多线程之Thread实现
 * 面试题目：
 * 1. 请解释Thread和Runnable接口实现多线程的区别。
 *
 *
 * @author 余修文
 * @date 2019/1/21 9:23
 */
public class ThreadDemoReviewDemo02 {

    public static void main(String[] args) {
        //ThreadDemo03 demo = new ThreadDemo03();
        //demo.start();
        RunnableDemo04 demo04 = new RunnableDemo04();
        new Thread(demo04, "线程A").start();
        new Thread(demo04, "线程B").start();
        new Thread(demo04, "线程C").start();
    }

}

class ThreadDemo03 extends Thread {

    /**
     * 代码块：
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            /**
             * setName(),  getName(), getPriority, setPriority, MAX_PRIORITY, MIN_PRIORITY, NOR_PRIORITY
             */
            System.out.println(Thread.currentThread().getName() + "-- 访问了" + (i+1) + "次。");
            System.out.println("该线程的优先级为：" + Thread.currentThread().getPriority());
        }
    }
}

class RunnableDemo04 implements Runnable {
    private Integer ticket = 100;

    /**
     * 代码块：
     * 1. 静态块 -- static
     * 2. 构造块 -- struct
     * 3. 同步块 -- synchronized
     * 4. 普通块
     */
    @Override
    public void run() {
        /**
         * 同步块有两种方法：
         * 1. 同步方法
         * 2. 同步代码块
         */
        //synchronized (this) {
        //    while (ticket > 0) {
        //        System.out.println(Thread.currentThread().getName() + "买了一张票,剩余：" + (--this.ticket) + "张。");
        //    }
        //}
        sale();
    }

    public synchronized void sale() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "买了一张票，剩余：" + (--this.ticket) + "张。");
        }
    }
}
