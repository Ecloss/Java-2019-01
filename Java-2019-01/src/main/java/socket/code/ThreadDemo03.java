package socket.code;

import org.junit.Test;

import java.io.IOException;
import java.security.PublicKey;

/**
 * 多线程的常用方法
 * Thread有getName，setName获取这个现成的名字
 * public Thread(Thread target, String name);  构造函数
 * 还有直接获取这个线程的name
 * public static Thread currentThread();  直接获取这个线程的name
 *
 * @author 余修文
 * @date 2019/1/19 11:19
 */
public class ThreadDemo03 {

    /**
     * junit的test方法  和  main方法分配的线程池不一样。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("主线程的优先级为：" + Thread.currentThread().getPriority());
        ThreadDemo01 demo01 = new ThreadDemo01("XiaoBai-01");
        Thread thread = new Thread(demo01, "XiaoBai-01");
        Thread thread1 = new Thread(demo01, "XiaoBai-02");
        Thread thread2 = new Thread(demo01, "XiaoBai-03");
        thread.setPriority(Thread.MAX_PRIORITY);
        //thread1.setPriority(Thread.MIN_PRIORITY);
        //thread2.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
        thread2.start();
        //thread.run();
    }

    /**
     * main其实就是一个线程，通过Thread.currentThread.getName() 获取到的名字就是name
     *
     * @Test 其实也是一个线程，名字也叫做main
     */
    @Test
    public void demo01() {
        ThreadDemo01 thread = new ThreadDemo01();
        thread.run();
    }

    @Test
    public void demo02() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {

        }
    }

    @Test
    public void demo03() {
        ThreadDemo01 threadDemo01 = new ThreadDemo01();
        new Thread(threadDemo01, "XiaoBai").start();
    }

}

class ThreadDemo01 implements Runnable {

    private String name;

    public ThreadDemo01(String name) {
        this.name = name;
    }

    public ThreadDemo01() {

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", i = " + i);
        }
    }
}
