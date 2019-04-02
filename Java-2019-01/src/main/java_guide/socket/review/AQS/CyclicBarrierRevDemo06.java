package socket.review.AQS;

import java.util.concurrent.*;

/**
 * 循环栅栏
 *
 * @author 余修文
 * @date 2019/4/2 8:58
 */
public class CyclicBarrierRevDemo06 {

    private static final int threadCount = 550;

    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        System.out.println("threadNum：" + threadNum + "  is ready");
        CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
        System.out.println("threadNum:  " + threadNum + " is finish");
    }

}
