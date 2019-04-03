package lambda.function_interface.test_interface;

import java.util.Objects;

/**
 * @author 余修文
 * @date 2019/4/3 9:53
 */
@FunctionalInterface
public interface PredicateDemo01<T> {

    boolean test(T t);

    // and 方法与关系运算符 “&&” 相似，两边都成立才返回true
    default PredicateDemo01<T> and(PredicateDemo01<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    // 非，对判断取反
    default PredicateDemo01<T> negate() {
        return (t) -> !test(t);
    }

    // 或者，只要有一个成立就返回true
    default PredicateDemo01<T> or(PredicateDemo01<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> PredicateDemo01<T> isEqual(Objects targetRef) {
        return (null == targetRef) ? Objects::isNull : object -> targetRef.equals(object);
    }

}
