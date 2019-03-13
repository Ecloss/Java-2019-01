package socket.code;

/**
 * volatile的作用：
 * 双重校验锁实现对象单例
 * 单例模式的几个重要特征：
 * 1. 一个静态变量
 * 2. 为空的构造方法
 * 3. 静态实例化方法get
 *
 * @author 余修文
 * @date 2019/3/13 10:04
 */
public class Singleton {

    /**
     * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，当有其他线程需要读取时，它会去内存中读取新值。
     * volatile的作用：
     * 1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
     * 2）禁止进行指令重排序
     */
    private volatile static Singleton uniqueInstance;

    public Singleton() {
    }

    // 静态方法
    public static Singleton getUniqueInstance() {
        // 先判断对象是否被实例化
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}

/**
 * 代码分析：
 * unqiueInstance = new Singleton();  是分三步执行的
 * 1. 为uniqueInstance 分配内存空间
 * 2. 初始化uniqueInstance
 * 3. 将uniqueInstance 指向分配的内存地址
 */
