package socket.code.synchronizedCode;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁和悲观锁
 *
 * @author 余修文
 * @date 2019/4/19 14:01
 */
public class LockHappySad {

    /**
     * 悲观锁：总是假设最坏的情况，共享资源每次只给一个线程使用，其他线程阻塞
     * 用完后再把资源转让给其它线程
     * 乐观锁：适用于多读的类型
     * 一般情况下使用CAS算法，或版本号机制实现
     * CAS：compare and swap 比较和交换写法
     * CAS一般用于读的场景居多，
     * Synchronized多用于写的场景
     */
    @Test
    public void demo01() {
        AtomicInteger atomicInteger = new AtomicInteger(1);
    }

}
