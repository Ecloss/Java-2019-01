package lambda.function_interface.test_interface;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author 余修文
 * @date 2019/4/3 11:07
 */
@FunctionalInterface
public interface FunctionsDemo<T, R> {

    // 返回一个R，做一个t
    R apply(T t);

    /**
     * ? super V 代表 ? 是V 的同类或者父类
     * ? extends T 代表 ？ 是T的子类或者T本身
     * 将两个Function整合，并返回一个能够执行两个Function对象功能的Function对象
     */
    default <V> FunctionsDemo<V, R> compose(FunctionsDemo<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return v -> apply(before.apply(v));
    }

    default <V> FunctionsDemo<T, V> andThen(FunctionsDemo<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> FunctionsDemo<T, T> identity() {
        return t -> t;
    }

}
