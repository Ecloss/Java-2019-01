package lambda.code;

/**
 * @author 余修文
 * @date 2019/4/2 16:48
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
