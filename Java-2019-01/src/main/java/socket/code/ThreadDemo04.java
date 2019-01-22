package socket.code;

/**
 * Thread线程
 *
 * @author 余修文
 * @date 2019/1/19 20:46
 */
public class ThreadDemo04 {

    /**
     * 今天所学Name
     * 1. getName()
     * 2. setName() 给线程起名字
     * 3. getPriority();
     * 4. setPriority();    设置优先级
     * 5. MAX_PRIORITY, MIN_PRIORITY, NOM_PRIORITY
     * 6. sleep() 阻塞状态，但是会有一个阻塞异常
     */
    public static void main(String[] args) {
        ThreadDemo05 thread = new ThreadDemo05();
        //System.out.println("main 的优先级为：" + Thread.currentThread().getPriority());
        Thread thread1 = new Thread(thread, "Yueel");
        Thread thread2 = new Thread(thread, "XiaoBai");
        //Thread thread1 = new Thread(thread);
        //thread1.setName("XiaoBai");
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();

    }

}

class ThreadDemo05 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "----" + (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
