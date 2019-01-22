## 多线程的讲解
----------
> Thread有单继承的局限性，继承了Thread父类就不能继承其他类。这在实际情况中
> 是不合常规的，因此最好是使用Runnable接口。

> Thread 和 Runnable 实现多线程的两种方法

> Run, start() 方法

> sleep()  睡眠方法

> setName, getName, 构造方法(Thread, Name);  设置线程名字

> setPriority getPriority MAX_PRIORITY MIN_PRIORITY

> NOR_POIORITY, Thread.currentThread() 获取当前线程

> 同步：synchronized，代码块：普通代码块，同步块，构造块，静态块。

> 死锁，

> Object: notify() 唤醒状态， wait()等待状态， notifyAll() 唤醒所有线程，那个优先级高
> 就先同步哪一个

> 1. 请解释Thread 和 Runnable 的区别

> 答案：Thread 是一个实现类，而Runnable是一个接口，
> Thread是继承的方式实现，而Runnable是实现接口的方式实现，
> 因此使用Runnable能够避免父类单继承的局限性
>  Runnable 接口实现的多线程可以比Thread类的实现多线程更加清晰的描述数据共享的概念。

> 2. 请解释多个线程访问同一个资源的时候，要考虑到那些情况。有可能带来哪些问题？

> 多个线程访问同一个资源的时候，一定要注意同步的问题，关键字是：Synchronized, 可以使用
> 同步代码块，或者同步方法，代码如下：
```java
    public class Demo implements Runnable {
     
    @Override
    public void run(){
        synchronized (this){
            /* 代码块 */
        }
    }
    
    public synchronized void sale(){
        /* 代码块 */ 
    }

}
```

> 3. 请解释sleep 和wait 区别？
> 答案：sleep 是睡眠，等到时间一到就自动唤醒。 wait需要notify() 方法去唤醒
> sleep 是Thread类的方法， wait是Object的方法。