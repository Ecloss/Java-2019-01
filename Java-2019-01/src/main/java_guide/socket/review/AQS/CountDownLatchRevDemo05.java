package socket.review.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 计时器
 *
 * @author 余修文
 * @date 2019/4/2 8:53
 */
public class CountDownLatchRevDemo05 {

    private static final int threadCount = 550;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 表示一个请求已经被完成
                    countDownLatch.countDown();
                }
            });
        }
        threadPool.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:  " + threadNum);
        Thread.sleep(1000);

    }

}
