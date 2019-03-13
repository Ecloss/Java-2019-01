package socket.code;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用原子类型
 *
 * @author 余修文
 * @date 2019/3/13 17:04
 */
public class AtomicReferenceDemo02 {

    /**
     * AtomicReference：引用类型原子类
     * AtomicStampedReference：原子更新引用类型里的字段原子类
     * AtomicMarkableReference：原子更新带有标记为的引用类型
     */
    public static void main(String[] args) {
        AtomicReference<Person> atomicReference = new AtomicReference<>();
        Person person = new Person("XiaoBai", 21);
        atomicReference.set(person);
        System.out.println(atomicReference.get().toString());
        Person person1 = new Person("Yueel", 22);
        System.out.println("After use compareAndSet(person,person1)：" + atomicReference.compareAndSet(person, person1));
        System.out.println(atomicReference.get().toString());

    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}