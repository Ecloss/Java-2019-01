package lambda.function_interface;

/**
 * 获取默认方法
 *
 * @author 余修文
 * @date 2019/4/2 16:16
 */
public interface Formula {

    double calulate(int a);

    /**
     * 获取算术平方根
     *
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
