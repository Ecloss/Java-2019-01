package socket.review;

import org.junit.Test;

import java.io.IOException;

/**
 * 多线程实现Runnable方法
 *
 * @author 余修文
 * @date 2019/1/18 15:26
 */
public class RunnableDemo01Test {

    @Test
    public void demo01() {
        RunnableDemo07 runnable = new RunnableDemo07("线程A");
        //RunnableDemo07 runnable1 = new RunnableDemo07("线程B");
        //RunnableDemo07 runnable2 = new RunnableDemo07("线程C");
        //new Thread(runnable).start();
        //new Thread(runnable1).start();
        //new Thread(runnable2).start();
        Thread thread = new Thread(runnable);
        try {
            thread.start();
            thread.isAlive();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println(thread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 为什么我不设置守护线程，就会出现线程不停止，
     * 设置了之后，线程关掉5秒后就再也不会显示了
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        try {
            Protect01 demo01 = new Protect01();
            //Thread2 thread2 = new Thread2();
            //Thread thread3 = new Thread(thread2);
            //thread3.start();
            Thread thread = new Thread(demo01);
            thread.setDaemon(true);
            thread.start();
            System.out.println(thread.isDaemon());
            Thread.sleep(5000);
            System.out.println("我离开Thread也不需要打印了，也就是停止了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo02() {
        try {
            Protect01 demo01 = new Protect01();
            Thread thread = new Thread(demo01);
            thread.setDaemon(true);
            Thread.sleep(5000);
            System.out.println("我离开Thread也不需要打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

class RunnableDemo07 implements Runnable {
    private String name;

    public RunnableDemo07(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

}

class InterruptThread2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了！我要退出了");
                return;
            }
            System.out.println("i = " + (i + 1));
        }
        System.out.println("看到这句话说明线程并未终止---------");
    }
}

class Protect01 implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunnableDemo10 implements Runnable {
    private int  i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread11 extends Thread {
    private int  i = 10;

    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //System.out.println("i = " + (i + 1));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}