package socket.code;

/**
 * 多线程之Thread
 *
 * @author 余修文
 * @date 2019/1/19 10:18
 */
public class ThreadDemo02 {

    /**
     * 我们从买票开始入手，
     * 1. 调用的是start方法，而不是run方法
     * 2. 买票应该是多个线程同时进行的
     *
     */
    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo("小白");
        ThreadDemo thread1 = new ThreadDemo("Yueel");
        ThreadDemo thread2 = new ThreadDemo("小猴子");
        thread.start();
        thread1.start();
        thread2.start();
    }

}

class ThreadDemo extends Thread {

    private Integer ticket = 200;

    private String name;

    public ThreadDemo() {
    }

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ticket > 1) {
            System.out.println(this.name + "买了一张，剩余：" + (ticket--) + "张票");
        }
    }

}
