package socket.code;

import java.io.IOException;

/**
 * 多线程之同步与死锁
 * 多个线程访问同一个资源的时候，就需要进行同步
 * 同步操作与异步操作相比：异步操作的执行速度要高于同步操作，
 * 但是同步操作的数据的安全性较高，属于安全的线程操作。
 *
 * @author 余修文
 * @date 2019/1/20 10:59
 */
public class ThreadDemo06 {

    public static void main(String[] args) throws IOException {
        ThreadDemo07 demo = new ThreadDemo07();
        new Thread(demo , "票A").start();
        new Thread(demo, "票B").start();
        new Thread(demo, "票C").start();
        new Thread(demo, "票D").start();
    }

}

/**
 * 关键字：Synchroized 关键字当前只允许一个对象进行操作
 */
class ThreadDemo07 implements Runnable {
    private Integer ticket = 100;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
                this.sale();
        }
    }

    /**
     * 同步方法
     */
    public synchronized void sale() {
        if (this.ticket > 0) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "进来了");
                System.out.println(Thread.currentThread().getName() + "买票，ticket 剩余" + this.ticket--);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}