package socket.code.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 高级的CyclicBarrier构造函数
 *
 * @author 余修文
 * @date 2019/3/29 17:27
 */
public class CyclicBarrierDemo02 {

    //  设置请求的数量
    private static final int threadCount = 550;

    //
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5, () -> {
        System.out.println("----当线程达到之后，有限制性----");
    });

    public static void main(String[] args) throws InterruptedException {
        // 创建线程池
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
                }
            });
        }
        threadPool.shutdown();
    }

    public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
        System.out.println("threadNum：" + threadNum + " is ready");
        CYCLIC_BARRIER.await();
        System.out.println("threadNum：" + threadNum + " is finish");
    }

}
