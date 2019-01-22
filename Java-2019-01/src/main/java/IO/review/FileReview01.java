package IO.review;

import java.io.*;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File类回顾：
 * Consumer：消费者， 接收一个参数，不返回任何参数
 * Supplier ：生产者，不接受任何参数，返回一个参数
 * Function：接收一个参数，返回一个参数
 * Predicate：接收一个参数，返回Boolean值
 *
 * @author 余修文
 * @date 2019/1/16 9:26
 */
public class FileReview01 {
    private static final int DEFAULT_SIZE = 1024 * 1024 * 2;

    public static void main(String[] args) throws IOException {
        //demo01();
        //System.out.println("--------------------分隔符-----------------------------");
        //System.out.println("FileInputStream  和 FileOutputStream");
        //demo02();
        //System.out.println("---------------------分隔符-----------------------------");
        //System.out.println("Writer 和 Reader 方法");
        //demo03();
        //System.out.println("------------------分隔符------------------------------");
        //System.out.println("FileInputStream  和 FileOutputStream 的copyText");
        //demo04();
        System.out.println("------------------分隔符------------------------------");
        System.out.println("Reader操作 和 Writer 的copyText操作");
        demo05();
    }

    /**
     * file的几个方法：
     * 1.exists()
     * 2. getParentFile()
     * 3.
     *
     * @throws IOException
     */
    public static void demo01() throws IOException {
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.getParentFile());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否是路径：" + file.isDirectory());
        System.out.println("该文件的长度为：" + file.length());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("该文件上次修改时间为：" + file.lastModified() + "(显示为时间戳)");
        System.out.println("该文件上次修改时间为：" + simpleDateFormat.format(new Date(file.lastModified())) + "(正常时间)");
        System.out.println("该文件的路劲为：" + file.getPath());
        String[] strFiles = file.list();
        System.out.println("该文件的目录为：" + strFiles);
    }

    /**
     * 字节流 InputStream-read, OutputStream-write
     */
    public static void demo02() throws IOException {
        /** fileInputStream */
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        //Path
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        String str = "We wont to see star";
        /** write方法：传入参数，并且不返回任何数据，属于消费者Consumer */
        outputStream.write(str.getBytes());
        outputStream.close();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);

            /** 创建一个缓冲区去读数据 */
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

    /**
     * 字符流 Reader-read，Writer-write
     */
    public static void demo03() throws IOException {
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        /** Writer write写方法输出流 */
        Writer writer = new FileWriter(file);
        String str = "人只是一颗有思想的芦苇。";
        /** write方法为消费者 */
        writer.write(str);
        writer.close();
        /** Reader read方法 */
        Reader reader = new FileReader(file);
        char[] data = new char[1024];
        /** function 函数 */
        int len = reader.read(data);
        System.out.println(new String(data, 0, len));
        reader.close();
    }

    /**
     * InputStream 和 FileOutputStream的Copy
     */
    public static void demo04() throws IOException {
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        File copyFile = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemoCopy02");
        /** 如果文件不存在，就创建这两个文件 */
        if (!file.getParentFile().exists()) {
            file.getParentFile().createNewFile();
        }
        if (!copyFile.getParentFile().exists()) {
            copyFile.getParentFile().createNewFile();
        }
        /** 对FileDemo01进行读操作 */
        FileInputStream inputStream = new FileInputStream(file);
        /** 对FileDemoCopy02进行写操作 */
        FileOutputStream outputStream = new FileOutputStream(copyFile);
        byte[] buf = new byte[DEFAULT_SIZE];
        int len = 0;

        if ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }
        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("关闭IO流出错！");
        }
    }

    /**
     * Writer 和 Reader的Copy操作
     */
    public static void demo05() throws IOException {
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        File copyFile = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemoCopy02");
        if (!file.getParentFile().exists()) {
            file.getParentFile().createNewFile();
        }
        if (!copyFile.getParentFile().exists()) {
            copyFile.getParentFile().exists();
        }
        /** Reader读操作 */
        Reader reader = new FileReader(file);
        /** Writer写操作 */
        Writer writer = new FileWriter(copyFile);
        char[] buf = new char[DEFAULT_SIZE];
        int len = 0;
        /** read读方法是一个Function */
        while ((len = reader.read(buf)) != -1) {
            writer.write(new String(buf, 0, len));
        }
        //len = reader.read(buf);
        /** 进行写操作 */
        /** 关闭流操作 */
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println("关闭流异常！");
        }
    }

}
