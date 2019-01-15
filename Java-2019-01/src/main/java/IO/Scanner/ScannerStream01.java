package IO.Scanner;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * 扫描流
 *
 * @author 余修文
 * @date 2019/1/15 13:54
 */
public class ScannerStream01 {

    public static void main(String[] args) throws IOException {
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
