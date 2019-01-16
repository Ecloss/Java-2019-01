package IO.review;

import java.io.*;

/**
 * 序列化复习
 *
 * @author 余修文
 * @date 2019/1/16 14:12
 */
public class SerializableDemo03 {

    public static void main(String[] args) throws Exception {
        //ser();
        dser();
    }

    /**
     * 序列化
     */
    private static void ser() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("src/main/file/FileDemo01")));
        outputStream.writeObject(new Book("Java", "89.1"));
        outputStream.close();
    }

    /**
     * 反序列化
     */
    private static void dser() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("src/main/file/FileDemo01")));
        Object obj = inputStream.readObject();
        Book book = (Book) obj;
        System.out.println(book.getPrice() + "\n" + book.getTitle());
    }

}


class Book implements Serializable {
    private static final long serialVersionUID = -9204509834405062231L;

    /**
     * 关键字transient，标记了此关键字，当序列化和反序列化的时候就不会生成该数据
     */
    private String title;

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
