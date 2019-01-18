package thread.one.thread;

import org.junit.Test;

/**
 * 线程测试demo02
 *
 * @author 余修文
 * @date 2019/1/18 14:39
 */
public class ThreadDemo02 {

    @Test
    public void demo01() {
        ThreadDemo01 thread = new ThreadDemo01();
        thread.run();
    }

    @Test
    public void demo02() {
        ThreadDemo thread = new ThreadDemo("线程A");
        ThreadDemo thread2 = new ThreadDemo("线程B");
        ThreadDemo thread3 = new ThreadDemo("线程C");
        thread.start();
        thread2.start();
        thread3.start();
        /** 一个线程不能进行两次start方法，源码如下： */
        /**
         * if (threadStatus != 0)
         *             throw new IllegalThreadStateException();
         */
        //thread.start();
    }

}

class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.name + "---->" + (i+1));
        }
    }
}