package IO.Scanner;

import java.io.*;

/**
 * 序列化与反序列化
 *
 * @author 余修文
 * @date 2019/1/15 16:38
 */
public class SerializableDemo02 implements Serializable {
    /**
     * 此对象可被序列化
     */
    private static final long serialVersionUID = -5442246051651927758L;

    public static void main(String[] args) throws Exception {
        ser1();
        der1();
    }

    /**
     * 序列化
     *
     * @throws Exception
     */
    public static void ser() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("src/main/file/FileDemo01")));
        oos.writeObject(new Book("Java", "123.12"));
        oos.close();
    }

    /**
     * 反序列化
     *
     * @throws Exception
     */
    public static void dser() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("src/main/file/FileDemo01")));
        Object obj = ois.readObject();
        Book book = (Book)obj;
        System.out.println(book.getPrice() + "\n" + book.getTitle());
    }

    public static void ser1() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/file/FileDemo01"));
        oos.writeObject(new Book("Python", "89.89"));
        oos.close();
    }

    public static void der1() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/file/FileDemo01"));
        Object obj = ois.readObject();
        Book book = (Book) obj;
        System.out.println(book.getPrice() + "\n" + book.getTitle());
    }

}

class Book implements Serializable {
    private static final long serialVersionUID = -9204509834405062231L;

    /**
     * 关键字transient，标记了此关键字，当序列化和反序列化的时候就不会生成该数据
     */
    private transient String title;

    private String price;

    public Book(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
