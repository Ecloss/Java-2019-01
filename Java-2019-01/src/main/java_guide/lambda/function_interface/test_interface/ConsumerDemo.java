package lambda.function_interface.test_interface;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author 余修文
 * @date 2019/4/3 13:38
 */
public interface ConsumerDemo<T> {

    void accept(T t);

    default ConsumerDemo<T> andThen(ConsumerDemo<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {accept(t); after.accept(t);};
    }

}
