package socket.code;

import org.junit.Test;

/**
 * 多线程之Runnable
 *
 * @author 余修文
 * @date 2019/1/19 10:14
 */
public class RunnableDemo01 {

    public static void main(String[] args) {
        RunnableDemo runnable = new RunnableDemo("XiaoBai-01");
        RunnableDemo runnable1 = new RunnableDemo("XiaoBai-02");
        RunnableDemo runnable3 = new RunnableDemo("XiaoBai-03");
        new Thread(runnable).start();
        new Thread(runnable1).start();

    }

    /**
     * Thread类有getName，setName设置线程的名字
     * public Thread(Runnable target,  String name)
     */
    @Test
    public void demo01() {
        RunnableDemo runnableDemo = new RunnableDemo("xiaobai");
        Thread thread = new Thread(runnableDemo, "Demo01");
        System.out.println(thread.getName());
    }

}

class RunnableDemo implements Runnable {

    private Integer ticket = 100;

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }

    public RunnableDemo() {
    }

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(this.name + "买了一张票，还有：" + (ticket--));
        }
    }
}
