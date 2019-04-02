package socket.review.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Semaphore线程
 *
 * @author 余修文
 * @date 2019/4/2 8:44
 */
public class SemaphoreRevDemo04 {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum：" + threadNum);
        Thread.sleep(1000);
    }

}
