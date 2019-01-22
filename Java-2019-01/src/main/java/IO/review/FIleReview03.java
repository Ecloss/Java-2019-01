package IO.review;

import java.io.*;

/**
 * 文件操作处理流
 *
 * @author 余修文
 * @date 2019/1/22 9:59
 */
public class FIleReview03 {
    private static File file = new File("src/main/file/FileDemo01");
    private static File copy_file = new File("src/main/file/FileDemoCopy02");
    private static final int DEFAULT_SIZE = 1024 * 1024 * 2;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //demo01();
        //demo02();
        //demo03();
        ser();
        dser();
    }

    /**
     * FileInputStream 和FileOutputStream
     */
    public static void demo01() throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(file);
        String str = "God is girl";
        outputStream.write(str.getBytes());
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buf = new byte[DEFAULT_SIZE];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void demo02() throws IOException {
        OutputStream outputStream = new FileOutputStream(file);
        String str = "I like everyOne, oh oh oh";
        outputStream.write(str.getBytes());
        outputStream.close();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] buf = new byte[DEFAULT_SIZE];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        outputStream.close();
    }

    /**
     * FileReader, FileWriter
     */
    public static void demo03() throws IOException {
        FileReader reader = new FileReader(file);
        Writer writer = new FileWriter(copy_file);
        int len = 0;
        char[] buf = new char[DEFAULT_SIZE];
        while ((len = reader.read(buf)) != -1) {
            writer.write(new String(buf, 0, len));
        }
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("关闭流异常");
        }
    }

    /**
     * 序列化
     */
    public static void ser() throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new Book("Zookeeper", "123.12"));
        outputStream.close();
    }

    /**
     * 反序列化
     */
    public static void dser() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object obj = inputStream.readObject();
        Book book = (Book) obj;
        System.out.println(book.getTitle() + "\n" + ((Book) obj).getPrice());
    }

}
