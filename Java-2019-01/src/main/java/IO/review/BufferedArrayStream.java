package IO.review;

import java.io.*;

/**
 * 内存存储流
 *
 * @author 余修文
 * @date 2019/1/22 10:48
 */
public class BufferedArrayStream {

    public static void main(String[] args) throws IOException {
        demo01();
    }

    public static void demo01() throws IOException {
        String str = "Hello world";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(Character.toUpperCase(len));
        }
        System.out.println(outputStream);
    }

}
