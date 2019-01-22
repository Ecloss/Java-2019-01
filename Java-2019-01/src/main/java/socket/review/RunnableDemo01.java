package socket.review;

import org.junit.Test;

/**
 * 多线程实现Runnable方法
 *
 * @author 余修文
 * @date 2019/1/18 15:26
 */
public class RunnableDemo01 {

    @Test
    public void demo01() {
        RunnableDemo runnable = new RunnableDemo("线程A");
        RunnableDemo runnable1 = new RunnableDemo("线程B");
        RunnableDemo runnable2 = new RunnableDemo("线程C");
        new Thread(runnable).start();
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

}

class RunnableDemo implements Runnable {
    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.name + "----> " + i);
        }
    }

}
