package socket.review;

/**
 * 单例模式
 *
 * @author 余修文
 * @date 2019/3/18 13:43
 */
public class SingletonDemoReviewDemo01 {

    /**
     * 使用Volatile 关键字有两个作用
     * 1. 保证了了不同线程对这个变量的可操作性
     * 2. 禁止指令重新排序
     */
    private volatile static SingletonDemoReviewDemo01 UNIQUE_INSTANCE;

    public SingletonDemoReviewDemo01() {
    }

    public static SingletonDemoReviewDemo01 getInstance() {
        if (UNIQUE_INSTANCE == null) {
            UNIQUE_INSTANCE = new SingletonDemoReviewDemo01();
        }
        return UNIQUE_INSTANCE;
    }

}
