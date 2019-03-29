package socket.code.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量，允许多个线程同时访问
 *
 * @author 余修文
 * @date 2019/3/29 15:31
 */
public class SemaphoreDemo {

    /**
     * Synchronized 和 ReenTrantLock 都是一次只允许一个线程访问某个资源，Semaphore（）可以指定多个线程同时访问某个资源
     */
    // 建立最大的线程数量
    private static final int threadCount = 550;

    /**
     * Semphore 的线程：
     * isHeldExclusively()//该线程是否正在独占资源。只有用到condition才需要去实现它。
     * tryAcquire(int)//独占方式。尝试获取资源，成功则返回true，失败则返回false。
     * tryRelease(int)//独占方式。尝试释放资源，成功则返回true，失败则返回false。
     * tryAcquireShared(int)//共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
     * tryReleaseShared(int)//共享方式。尝试释放资源，成功则返回true，失败则返回false。
     */

    public static void main(String[] args) {
        // 建立线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // 最多可共享的线程
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            // 差个多个线程是否同时进行
            threadPool.execute(() -> {
                        try {
                            // 如果总数有20个线程，每个线程拿走5个许可证，那么每次就只有4个线程同时运行
                            semaphore.acquire(5);
                            test(threadnum);
                            semaphore.release(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        /**
         * 结果证明，threadNum：多线程确实可以20个线程同时进行
         */
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum：" + threadNum);
        Thread.sleep(1000);
    }

}
