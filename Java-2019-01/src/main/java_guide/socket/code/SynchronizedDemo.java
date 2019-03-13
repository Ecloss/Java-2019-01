package socket.code;

/**
 * synchronize关键字底层原理
 *
 * @author 余修文
 * @date 2019/3/13 10:27
 */
public class SynchronizedDemo {
    /**
     * 锁的状态：无锁状态，偏向锁状态，轻量级锁状态，重量级锁状态
     * 偏向锁失败后，不会立即膨胀为重量级锁，而是先升级为轻量级锁
     * 自旋锁和自适应锁：
     * 锁消除，锁粗化
     * （偏向锁，轻量级锁，自旋锁和自适应锁，锁消除，锁粗化）
     */

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块！");
        }
    }

}
