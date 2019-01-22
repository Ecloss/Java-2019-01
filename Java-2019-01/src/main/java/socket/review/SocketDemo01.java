package socket.review;

/**
 * 多线程回顾
 * 1. 多线程的实现：Thread，Runnable，Thread和Runnable两种实现方式的区别
 *
 * @author 余修文
 * @date 2019/1/20 15:04
 */
public class SocketDemo01 {

    public static void main(String[] args) {
        /* Runnable接口的实现 */
        //Runnable runnable = new RunnableDemo01();
        //new Thread(runnable, "线程A").start();
        //new ThreadDemo01().start();
        //System.out.println("main线程的优先级为：" + Thread.currentThread().getPriority() + "\n" + "main线程的名称为：" + Thread.currentThread().getName());
        RunnableDemo02 demo02 = new RunnableDemo02();
        new Thread(demo02, "XiaoBai").start();
    }

}

/**
 * Runnable接口继承的实现
 */
class RunnableDemo01 implements Runnable {
    private String name;

    @Override
    public void run() {
        System.out.println("线程的名字为：" + Thread.currentThread().getName());
        System.out.println("线程的优先级为：" + Thread.currentThread().getPriority());
    }
}

/**
 * Thread 继承父类实现多线程
 */
class ThreadDemo06 extends Thread {

    @Override
    public void run() {
        System.out.println("线程的名字为：" + currentThread().getName());
        System.out.println("线程的优先级为："+ currentThread().getPriority());
    }
}

/**
 * 使用Runnable接口与Thread类相比，解决了单继承的局限性。所以不管这两者的区别于联系是什么，至少在这一点上，如果需要一定要使用Runnable接口
 * 使用Runnable接口可以比Thread类能更好的描述出数据共享这一概念。
 * 数据共享指的是多个线程访问统一资源的操作。
 */
class RunnableDemo02 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "访问了" + (i + 1) + "次。");
        }
    }
}

