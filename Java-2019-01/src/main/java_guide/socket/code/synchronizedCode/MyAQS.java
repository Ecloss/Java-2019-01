package socket.code.synchronizedCode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义的AQS锁
 *
 * @author 余修文
 * @date 2019/4/19 14:41
 */
public class MyAQS extends AbstractQueuedSynchronizer {

    private static final long serialVersionUID = 3863161382258358971L;

    private volatile int state;

    protected MyAQS() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
