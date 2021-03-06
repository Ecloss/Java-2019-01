package socket.review.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.Executors.*;

/**
 * 共享资源
 *
 * @author 余修文
 * @date 2019/4/1 8:55
 */
public class SemaphoreDemoRev01 {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService threadPool = newFixedThreadPool(300);
        final Semaphore semaphore = new Semaphore(20);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    // 独占资源
                    semaphore.acquire(4);
                    test(threadNum);
                    // 分享资源
                    semaphore.release(4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum : " + threadNum);
        Thread.sleep(1000);
    }

}
