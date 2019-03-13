package socket.demo;

import org.junit.Test;
import socket.code.SynchronizedDemo;

/**
 * 实例化模式
 *
 * @author 余修文
 * @date 2019/3/13 10:19
 */
public class SingletonDemo01 {

    public volatile static SingletonDemo01 singletonDemo01;

    public SingletonDemo01() {
    }

    public static SingletonDemo01 getSingletonDemo01() {
        if (singletonDemo01 == null) {
            singletonDemo01 = new SingletonDemo01();
        }
        return singletonDemo01;
    }

    @Test
    public void demo01() {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method();
    }
}
