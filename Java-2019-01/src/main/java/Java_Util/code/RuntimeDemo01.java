package Java_Util.code;

import org.junit.Test;

import java.io.IOException;

/**
 * Runtime
 *
 * @author 余修文
 * @date 2019/1/24 19:54
 */
public class RuntimeDemo01 {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        /* 返回字节 */
        System.out.println("1-max = " + runtime.maxMemory());
        System.out.println("1-total = " + runtime.totalMemory());
        System.out.println("1-free = " + runtime.freeMemory());
        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += i;
        }
        /* 产生大量垃圾 */
        System.out.println("2-max = " + runtime.maxMemory());
        System.out.println("2-total = " + runtime.totalMemory());
        System.out.println("2-free = " + runtime.freeMemory());
        /* 释放垃圾空间，垃圾回收机制 */
        runtime.gc();
        System.out.println("3-max = " + runtime.maxMemory());
        System.out.println("3-total = " + runtime.totalMemory());
        System.out.println("3-free = " + runtime.freeMemory());

    }

    @Test
    public void demo01() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("mspaint.exe");
        Thread.sleep(5000);
        process.destroy();
    }

    @Test
    public void demo02() {
        /* 请解释某项操作的执行时间 */
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 3000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * System 方法中的naoTime方法
     */
    @Test
    public void demo03() {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < 3000; i++) {
            str += i;
        }
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    @Test
    public void demo04() {
        Memory mem = new Memory();
        mem = null;
        System.gc();
    }

    @Test
    public void demo05() throws CloneNotSupportedException {
        Book book = new Book("Java开发", "80.9");
        Book bookA = (Book) book.clone();
        System.out.println(bookA.toString());
        bookA.setPrice("123");
        System.out.println(book.toString() + "\n");
        System.out.println(bookA.toString());
    }

}

class Memory {
    public Memory() {
        System.out.println("Look star");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("星星暗淡了！");
        throw new Exception("星星还会在出现");
    }


}

/**
 * Cloneable 方法
 */
class Book implements Cloneable {
    private String title;
    private String price;

    public Book(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 由于此类需要对象的克隆操作，所以才需要进行方法的覆写
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 调用Object的clone方法，由于clone方法是protect，因此需要重写clone方法
     * @return
     */


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
