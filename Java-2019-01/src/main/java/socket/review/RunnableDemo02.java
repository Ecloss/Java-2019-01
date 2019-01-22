package socket.review;

import org.junit.Test;

/**
 * Thread和Runnable的区别
 * 买票的例子
 *
 * @author 余修文
 * @date 2019/1/18 15:50
 */
public class RunnableDemo02 {

    @Test
    public void demo01() {
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }

}

class MyThread implements Runnable {

    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("买票：ticket = " + this.ticket--);
        }
    }
}
