package IO.Scanner;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 扫描流
 *
 * @author 余修文
 * @date 2019/1/15 13:54
 */
public class ScannerStream01 implements Serializable {

    /** 此对象可以被序列化 */
    private static final long serialVersionUID = 8244768499995523366L;

    public static void main(String[] args) throws IOException {
        demo01();
    }

    /**
     * 使用FileInputStream来获取file的数据
     */
    public static void demo01() throws IOException {
        Scanner in = new Scanner(new FileInputStream(new File("src/main/file/FileDemo01")));
        in.useDelimiter("\n");
        while (in.hasNext()) {
            System.out.println(in.next());
        }
        in.close();
    }

    public static void demo02() throws IOException {
        /**  准备接受键盘数据*/
        Scanner in = new Scanner(System.in);
        System.out.println("请输入内容：");
        if (in.hasNextDouble()) {
            double dou = in.nextDouble();
            System.out.println("输入内容：" + dou);
        } else {
            System.out.println("输入的不是数字，错误！");
        }
        in.close();
    }

}
