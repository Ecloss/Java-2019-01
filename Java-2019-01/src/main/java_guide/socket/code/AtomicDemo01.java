package socket.code;

import org.junit.Test;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类操作‘
 *
 * @author 余修文
 * @date 2019/3/13 15:08
 */
public class AtomicDemo01 {

    /**
     * 基本类型原子类：AtomicBoolean，AtomicInteger， AtomicLong
     * 数组类：AtomicIntegerArray，AtomicLongArray， AtomicReferenceArray
     * 引用类型：AtomicMarkableReference, AtomicReference, AtomicStampedReference
     * 对象的属性修改类型原子类：AtomicIntegerFiledUpdater, AtomicLongFiledUpdater, AtomicReferenceFiledUpdater
     */

    /**
     * 基本类型原子类：AtomicInteger
     * public final int get() //获取当前的值
     * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
     * public final int getAndIncrement()//获取当前的值，并自增
     * public final int getAndDecrement() //获取当前的值，并自减
     * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
     * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将该值设置为输入值（update）
     * public final void lazySet(int newValue)//最终设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
     */
    @Test
    public void demo01() {
        int temoValue = 0;
        AtomicInteger integer1 = new AtomicInteger(0);
        // get
        System.out.println("After use get()：" + integer1.get());
        // getAndSet()：获取原来的值，然后设置新的值
        integer1.getAndSet(3);
        System.out.println("After use getAndSet(3)：" + integer1.get());
        // getAndIncrement()：获取现在的值并且自增
        integer1.getAndIncrement();
        System.out.println("After use getAndIncrement()：" + integer1.get());
        // getAndDecrement()：获取现在的值并自减
        integer1.getAndDecrement();
        System.out.println("After use getAndDecrement()：" + integer1.get());
        // 获取当前的值，并且增加100
        integer1.getAndAdd(100);
        System.out.println("After use getAndAdd(100)：" + integer1.get());
        // compareAndSet(expect, update)
        System.out.println("After use compareAndSet(102, 1)：" + integer1.compareAndSet(integer1.get(), 1));
        System.out.println("After use compareAndSet(102, 1)：" + integer1.get());
        // incrementAndGet()：自增，然后＋1
        System.out.println("After use incrementAndGet()：" + integer1.incrementAndGet());
    }

    /**
     * AtomicBoolean 的用法：
     * get()
     * getAndSet()
     * lazySet()
     * set()
     * compareAndSet()
     */
    @Test
    public void demo02() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
    }

}

/**
 * 1. 多线程环境不使用原子类保证线程安全
 */
class Test01 {

    private volatile int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

/**
 * 2. 多线程环境使用原子类型保证线程安全
 */
class Test02 {

    private AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}

class AtomicTest03 {
    /**
     * setup to use Unsafe.compareAndSwapInt for updates(更新操作时提供“比较并替换”)
     */
    private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final long valueOffset;

    static {
        try {
            /**
             * CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。
             * UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，
             * 返回值是 valueOffset。另外 value 是一个volatile变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。
             */
            valueOffset = unsafe.objectFieldOffset
                    (AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile int value;
}

class AtomicTest04 {

    private static final Unsafe UNSAFE = Unsafe.getUnsafe();
    private static final long valueOffset;

    static{
        try {
            valueOffset = UNSAFE.objectFieldOffset(AtomicInteger.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }
}
