package socket.code.synchronizedCode;

import org.junit.Test;

/**
 * Synchronize的测试代码
 *
 * @author 余修文
 * @date 2019/4/19 12:43
 */
public class SynchronizedDemo01 {

    /**
     * 多线程的2中实现方式
     * Runnable
     * Thread
     * 如果不加同步方法，会导致线程不规律，如买票，存钱
     * 用Junit的test方法写线程好像有问题
     */
    public static void main(String[] args) {
        //Ticket ticket = new Ticket();
        //Thread A = new Thread(ticket, "威风凛凛的A");
        //Thread B = new Thread(ticket, "可爱机灵的B");
        //A.start();
        //B.start();

        Money money = new Money();
        Thread XiaoB = new Thread(money, "XiaoBai");
        Thread Yueel = new Thread(money, "Yueel");
        XiaoB.start();
        Yueel.start();

    }



}

/**
 * 使用Runnable实现
 */
class Ticket implements Runnable {
    int tickNum = 20;

    /**
     * synchronized 修饰实例方法
     */
    @Override
    public synchronized void run() {
        while (tickNum > 0) {
            System.out.println(Thread.currentThread().getName() + "进来了");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"买票，剩余：" + (--tickNum));
        }
    }
}

class Money extends Thread {
    int money = 550;

    @Override
    public void run() {
        /**
         * synchronized 修饰代码块
         */
        synchronized (this) {

            while (money > 0) {
                System.out.println(Thread.currentThread().getName() + "进来借50块钱了！");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                money = money - 50;
                System.out.println(Thread.currentThread().getName() + "走了，剩余：" + money);
            }


        }
    }
}


