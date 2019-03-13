package socket.code;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 对象的属性修改类型原子类
 *
 * @author 余修文
 * @date 2019/3/13 17:16
 */
public class AtomicUpdaterDemo01 {

    /**
     * 对象属性修改类型原子介绍：
     * 1. AtomicIntegerFieldUpdater：原子更新整形字段的更新器
     * 2. AtomicLongFiledUpdater：原子更新长真想字段的更新器
     * 3. AtomicStampedReference：原子更新带有版本号的引用类型。该类将整数值与引用关联起来，可用于解决院子的更新数据
     * 和数据的版本号，可以解决使用CAS进行原子更新时可能出现的ABA问题
     */
    public static void main(String[] args) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

        User user = new User("Java", 22);
        System.out.println(atomicIntegerFieldUpdater.get(user));
        System.out.println(atomicIntegerFieldUpdater.getAndSet(user, 25));
        atomicIntegerFieldUpdater.set(user, 26);
        System.out.println(atomicIntegerFieldUpdater.get(user));
    }

}

class User {
    private String name;

    public volatile int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
