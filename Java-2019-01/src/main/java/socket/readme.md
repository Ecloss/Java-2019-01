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
