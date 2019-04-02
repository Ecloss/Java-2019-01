package socket.code.AQS;

import java.util.concurrent.*;

/**
 * 循环栅栏
 *
 * @author 余修文
 * @date 2019/3/29 16:46
 */
public class CyclicBarrierDemo {

    // 请求的数量
    private static final int threadCount = 550;

    // 需要同步的线程数量
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(300);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum：" + threadNum + "  is ready");
        try {
            CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("----------------CyclicBarrierException-----------------");
        }
        System.out.println("threadNum：" + threadNum + "  is finish");
    }

}
