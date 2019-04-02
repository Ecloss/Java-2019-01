package socket.review.AQS;

import java.util.concurrent.*;

/**
 * 循环栅栏Demo
 *
 * @author 余修文
 * @date 2019/4/1 15:26
 */
public class CyclicBarrierRevDemo03 {

    public static final int threadCount = 550;

    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(() -> {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum：" + threadNum + " is ready");
        try {
            CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("------------CyclicBarrierException-----------");
        }
        System.out.println("threadNum：" + threadNum + " is finish");
    }

}
