package socket.code;

/**
 * 死锁
 *
 * @author 余修文
 * @date 2019/1/20 11:41
 */
public class DeadLockDemo07 implements Runnable {
    private static A a = new A();
    private static B b = new B();

    public static void main(String[] args) {
        new DeadLockDemo07();
    }

    public DeadLockDemo07() {
        new Thread(this).start();
        b.say(a);
    }

    @Override
    public void run() {
        a.say(b);
    }
}

class A {
    public synchronized void say(B b) {
        System.out.println("A说：你把本给我，我给你笔，否则不给！");
        b.get();
    }

    public synchronized void get() {
        System.out.println("A：得到了本，付出了笔");

    }

}

class B {
    public synchronized void say(A a) {
        System.out.println("B说：给笔给我，我给你本子，否则不给！");
        a.get();
    }

    public synchronized void get() {
        System.out.println("B：得到了笔，付出了本，否则还是什么都干不了！");
    }
}
