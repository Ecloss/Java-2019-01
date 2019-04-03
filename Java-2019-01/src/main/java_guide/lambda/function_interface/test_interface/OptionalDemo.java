package lambda.function_interface.test_interface;

import com.sun.istack.internal.NotNull;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 余修文
 * @date 2019/4/3 14:39
 */
public final class OptionalDemo<T> {

    private static final OptionalDemo<?> EMPTY = new OptionalDemo<>();

    private final T value;

    private OptionalDemo() {
        this.value = null;
    }

    public static <T> OptionalDemo<T> empty() {
        OptionalDemo<T> t = (OptionalDemo<T>) EMPTY;
        return t;
    }

    private OptionalDemo(T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> OptionalDemo<T> of(T value) {
        return new OptionalDemo<>(value);
    }

    /**
     * 如果为空就传给他一个空对象
     * @param value
     * @param <T>
     * @return
     */
    public static <T> OptionalDemo<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(ConsumerDemo<? super T> consumerDemo) {
        if (value != null) {
            consumerDemo.accept(value);
        }
    }

    public OptionalDemo<T> filter(PredicateDemo01<? super T> predicateDemo01) {
        Objects.requireNonNull(predicateDemo01);
        if (!isPresent()) {
            return this;
        } else {
            return predicateDemo01.test(value) ? this : empty();
        }
    }

    public OptionalDemo<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (!isPresent()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public <U> OptionalDemo<U> map(FunctionsDemo<? super T, ? extends U> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return OptionalDemo.ofNullable(mapper.apply(value));
        }
    }

    public <U> OptionalDemo<U> flatMap(FunctionsDemo<? super T, OptionalDemo<U>> mapper) {
        Objects.requireNonNull(mapper);
        if (!isPresent()) {
            return empty();
        } else {
            return Objects.requireNonNull(mapper.apply(value));
        }
    }

    public T orElse(T other) {
        return value != null ? value : other;
    }

    public T orElseGet(Supplier<? extends T> other) {
        return value != null ? value : other.get();
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
        if (value != null) {
            return value;
        } else {
            throw exceptionSupplier.get();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OptionalDemo)) {
            return false;
        }

        OptionalDemo<?> other = (OptionalDemo<?>) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return value != null ? String.format("Optional[%s]", value) : "Optional.empty";
    }
}
