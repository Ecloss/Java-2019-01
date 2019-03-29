package socket.code.AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS锁代码
 *
 * @author 余修文
 * @date 2019/3/29 14:12
 */
public class AQSDemo01 extends AbstractQueuedSynchronizer {

    /**
     * AQS是一个用来构建锁和同步器的框架，使用AQS能简单且高效地构造出应用广泛的大量的同步器，
     * 比如我们提到的ReentrantLock，Semaphore，
     * 其他的诸如ReentrantReadWriteLock，SynchronousQueue，FutureTask等等皆是基于AQS的。
     * 当然，我们自己也能利用AQS非常轻松容易地构造出符合我们自己需求的同步器。
     */

    /**
     * AQS 底层使用了模板方法：
     * 使用者继承AbstractQueueSynchronizer
     * 将AQS组合在自定义同步组件的视线中，并调用其模板方法，而这些模板方法会调用使用者重写的方法
     */

    /**
     * AQS的基本模板方法：
     * isHeldExclusively()//该线程是否正在独占资源。只有用到condition才需要去实现它。
     * tryAcquire(int)//独占方式。尝试获取资源，成功则返回true，失败则返回false。
     * tryRelease(int)//独占方式。尝试释放资源，成功则返回true，失败则返回false。
     * tryAcquireShared(int)//共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
     * tryReleaseShared(int)//共享方式。尝试释放资源，成功则返回true，失败则返回false。
     */

    private volatile int state;



}
