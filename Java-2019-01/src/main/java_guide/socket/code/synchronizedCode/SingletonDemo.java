package socket.code.synchronizedCode;

/**
 * 双重校验锁实现对象单例
 *
 * @author 余修文
 * @date 2019/4/19 13:45
 */
public class SingletonDemo {

    private volatile static SingletonDemo uniqueSingleton;

    public SingletonDemo() {
    }

    public SingletonDemo getUniqueSingleton() {
        if (uniqueSingleton == null) {
            synchronized (SingletonDemo.class) {
                if (uniqueSingleton == null) {
                    uniqueSingleton = new SingletonDemo();
                }
            }
        }
        return uniqueSingleton;
    }

}
