package java_util;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 测试
 *
 * @author 余修文
 * @date 2019/3/29 12:35
 */
public class TestDemo0329 {

    @Test
    public void demo01() {
        // 1011
        int a = 13;
        // 让a右移2位：0010
        System.out.println(a >> 16);
    }

    /**
     * 所谓 “拉链法” 就是：将链表和数组相结合。也就是说创建一个链表数组，
     * 数组中每一格就是一个链表。若遇到哈希冲突，则将冲突的值加到链表中即可
     */
    @Test
    public void demo02() {
        /**
         * AQS算法： AbstractQueuedSynchronizer
         * AQS是一个用来构建锁和同步器的框架，使用AQS能简单且高效地构造出应用广泛的大量的同步器
         */

    }

}
