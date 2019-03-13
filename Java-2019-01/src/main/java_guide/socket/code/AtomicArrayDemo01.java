package socket.code;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 数组类型原子类
 *
 * @author 余修文
 * @date 2019/3/13 16:09
 */
public class AtomicArrayDemo01 {

    /**
     * AtomicIntegerArray：整数数组原子类
     * AtomicLongArray：长整型数组原子类
     * AtomicReferenceArray：引用类型数组原子类
     */

    /**
     * public final int get(int i) //获取 index=i 位置元素的值
     * public final int getAndSet(int i, int newValue)//返回 index=i 位置的当前的值，并将其设置为新值：newValue
     * public final int getAndIncrement(int i)//获取 index=i 位置元素的值，并让该位置的元素自增
     * public final int getAndDecrement(int i) //获取 index=i 位置元素的值，并让该位置的元素自减
     * public final int getAndAdd(int delta) //获取 index=i 位置元素的值，并加上预期的值
     * boolean compareAndSet(int expect, int update) //如果输入的数值等于预期值，则以原子方式将 index=i 位置的元素值设置为输入值（update）
     * public final void lazySet(int i, int newValue)//最终 将index=i 位置的元素设置为newValue,使用 lazySet 设置之后可能导致其他线程在之后的一小段时间内还是可以读到旧的值。
     */
    @Test
    public void demo01() {
        // 数组的定义由两种：一种设置长度，另一种是直接设置数组的值
        int[] nums = {1, 2, 3, 4, 5, 3};
        AtomicIntegerArray integerArray = new AtomicIntegerArray(nums);
        // get(i) 获取索引下的值
        System.out.println("After use get(i)" + integerArray.get(5));
        // getAndSet(i, value) 找到索引i的值，然后赋给新的值
        System.out.println("After use getAndset(i)：" + integerArray.getAndSet(0, 5));
        System.out.println("After use getAndset(i)：" + integerArray.get(0));
        // getAdnIncrement(int i )：获取索引的值并且自增1
        System.out.println("After use getAndIncrement(1)：" + integerArray.getAndIncrement(1));
        System.out.println("After use getAndIncrement(1)：" + integerArray.get(1));
        // getAndDecrement(2)：获取当前的值
        System.out.println("After use getAndDecrement(2)：" + integerArray.getAndDecrement(2));
        System.out.println("After use getAndDecrement(2)：" + integerArray.get(2));
        // getAndAdd(i ,value)：获取当前索引的值，然后获取信额度值
        System.out.println("After use getAnaAdd(4, 10)： " + integerArray.getAndAdd(4, 10));
        System.out.println("After use getAnaAdd(4, 10)： " + integerArray.get(4));
        //integerArray.compareAndSet(i, except, update)：将索引为i，如果期望值相同，value设置为update
        System.out.println("After use compareAndSet(i, except, update)：" + integerArray.compareAndSet(4, 15, 100));
        System.out.println("After use compareAndSet(i, except, update)：" +integerArray.get(4));
    }



}
