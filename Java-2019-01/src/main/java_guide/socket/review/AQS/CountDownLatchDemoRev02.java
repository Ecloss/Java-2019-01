package socket.review.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器算法
 *
 * @author 余修文
 * @date 2019/4/1 15:14
 */
public class CountDownLatchDemoRev02 {

    // 请求的数量
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final  int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 表示一个请求已经被完成
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        // 进程关闭
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum：" + threadNum);
        Thread.sleep(1000);
    }

}
