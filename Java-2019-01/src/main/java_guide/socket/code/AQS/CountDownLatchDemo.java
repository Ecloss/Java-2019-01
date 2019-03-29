package socket.code.AQS;

import jdk.nashorn.internal.runtime.FindProperty;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器Demo
 *
 * @author 余修文
 * @date 2019/3/29 16:02
 */
public class CountDownLatchDemo {

    // 请求的数量
    private static final int threadCount = 550;

    /**
     * ①某一线程在开始运行前等待n个线程执行完毕。
     * 将 CountDownLatch 的计数器初始化为n ：new CountDownLatch(n) ，
     * 每当一个任务线程执行完毕，就将计数器减1 countdownlatch.countDown()，
     * 当计数器的值变为0时，在CountDownLatch上 await() 的线程就会被唤醒。
     * 一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
     *
     * ②实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，
     * 强调的是多个线程在某一时刻同时开始执行。类似于赛跑，将多个线程放到起点，
     * 等待发令枪响，然后同时开跑。做法是初始化一个共享的 CountDownLatch 对象，
     * 将其计数器初始化为 1 ：new CountDownLatch(1) ，多个线程在开始执行任务前首先
     * coundownlatch.await()，当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
     *
     * ③死锁检测：一个非常方便的使用场景是，你可以使用n个线程访问共享资源，
     * 在每次测试阶段的线程数目是不同的，并尝试产生死锁。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建一个具有固定线程数量的线程池对象，
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum：" + threadNum);
        Thread.sleep(1000);
    }

}
