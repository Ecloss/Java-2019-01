package IO.review;

import java.io.*;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * 打印流，System的输出流
 *
 * @author 余修文
 * @date 2019/1/16 13:30
 */
public class PrintStream02 {

    public static void main(String[] args) throws IOException {
        //demo01();
        //demo02();
        //demo03();
        //demo04();
        //demo05();
        demo06();
    }

    /**
     * 打印流PrintStream：主要方法为print，println方法
     * 功能：对文件进行写的功能：write
     * 主要方法为：BufferWriter，OutputStreamWriter
     */
    public static void demo01() throws IOException {
        File file = new File("F:\\Workspace\\Java-EE\\Java-2019-01\\src\\main\\file\\FileDemo01");
        PrintStream printStream = new PrintStream(file);
        printStream.print("Hello");
        printStream.println(" + World");
        printStream.println("我曾经跨过山河大海");
        printStream.println("也穿过人山人海");
        printStream.close();
    }

    /**
     * System 的三个对象 in, out, err
     * in: InputStream
     * out: PrintStream
     * err: PrintStream
     */
    public static void demo02() throws IOException {
        Consumer<String> consumer = System.out::println;
        consumer.accept("I like to anyThing");
    }

    /**
     * 缓冲输入流：
     * 字符缓冲区流：BufferedReader，BufferedWriter
     * 字节缓冲区流：BufferedInputStream， BufferedOutputStream
     */
    public static void demo03() throws IOException {
        /**
         * BufferedReader的public String readLine()
         *                 throws IOException
         */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数据：");
        /** 以回车作为换行 */
        String str = bufferedReader.readLine();
        System.out.println("输出的缓冲区流式：" + str);
        bufferedReader.close();
    }

    /**
     * 缓冲输入流
     */
    public static void demo04() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入年龄：");
        String str = bufferedReader.readLine();
        if (str.matches("\\d{1,3}")) {
            System.out.println("年龄是：" + Integer.parseInt(str));
        } else {
            System.out.println("年龄输入错误，应该有数字组成");
        }
    }

    /**
     * Scanner流的计算
     */
    public static void demo05() throws IOException {
        Scanner in = new Scanner(new FileInputStream(new File("src/main/file/FileDemo01")));
        in.useDelimiter("\n");
        while (in.hasNext()) {
            System.out.println(in.next());
        }
    }

    /**
     * Scanner流的计算是否为数字
     */
    public static void demo06() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入内容：");
        if (in.hasNextDouble()) {
            double dou = in.nextDouble();
            System.out.println("输出的数字为：" + dou);
        } else {
            System.out.println("输入的不是数字，请重新输入！");
        }
        in.close();
    }

}
