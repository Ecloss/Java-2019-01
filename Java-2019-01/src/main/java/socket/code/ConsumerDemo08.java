package socket.code;

import java.util.function.Consumer;

/**
 * 生产者和消费者demo
 *
 * @author 余修文
 * @date 2019/1/20 12:46
 */
public class ConsumerDemo08 {

    public static void main(String[] args) {
        Info info = new Info();
        new Thread(new Producter(info)).start();
        new Thread(new Consumer01(info)).start();
    }

}

class Info {
    private String title;
    private String content;
    /**
     * flag = true：表示可以生产，但是不可以取走
     * flag= false：表示可以取走，但是不可以生产
     */
    private boolean flag = true;

    public synchronized void set(String title, String content) {
        /* 重复进入到了set() 方法里面，发现不能够生产，所以要等待 */
        if (this.flag == false) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notify();
    }

    public synchronized void get() {
        /* 如果进入到了get()方法里面，不限不能够取走，因此需要等到 */
        if (this.flag == true) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.title + " - " + this.content);
        this.flag = true;
        super.notify();
    }

}

class Producter implements Runnable {

    private Info info;

    public Producter(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                    this.info.set("Yueel", "大美女");
            } else {
                    this.info.set("XiaoBai","大帅哥");
            }
        }
    }
}

class Consumer01 implements Runnable {

    private Info info;

    public Consumer01(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.info.get();
        }
    }
}