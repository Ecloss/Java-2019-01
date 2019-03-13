package socket.code;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronize 和 ReenTrantLocak的对比
 *
 * @author 余修文
 * @date 2019/3/13 10:55
 */
public class ReenTrantLockDemo {

    /**
     * 1. 两者都是可重入锁：
     * 2. synchronize 依赖于 JVM 而 ReenTrantLock 依赖于 API
     * 3. ReenTrantLock 比 Synchronize 增加了一些高级功能：
     * 一，等待可中断，二，可实现公平锁，三，可实现选择性通知
     */
    @Test
    public void demo01() {
        ReentrantLock lock = new ReentrantLock();
        try {
            // 等待可中断锁的概念
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * ReenTrantLock 锁：lock.lockInterruptibly() 处理等待锁
     * ReenTrantLock锁可以指定是公平锁还是非公平锁。而synchronized只能是非公平锁：
     * 公平锁：先等待的线程先获得锁，默认情况下是非公平的，可以通过ReenTrantLock类的ReenTrantLock(boolean fair) 构造方法来制定是否公平
     * 性能不再是选择标准
     */
    @Test
    public void demo02() {
        // 设置为true为公平锁，设置为false为非公平锁
        ReentrantLock lock = new ReentrantLock(true);
    }

    @Test
    public void demo03() {
    }

}
