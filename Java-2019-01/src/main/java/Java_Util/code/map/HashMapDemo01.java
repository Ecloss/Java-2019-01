package Java_Util.code.map;

import java.util.*;

/**
 * HashMap源码深度解析
 *
 * @author 余修文
 * @date 2019/2/28 15:27
 */
public class HashMapDemo01<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable {

    /**
     * JDK1.8 之前 HashMap 底层是 数组和链表 结合在一起使用也就是 链表散列。
     * HashMap 通过 key 的 hashCode 经过扰动函数处理过后得到 hash 值，
     * 然后通过 (n - 1) & hash 判断当前元素存放的位置（这里的 n 指的是数组的长度），
     * 如果当前位置存在元素的话，就判断该元素与要存入的元素的 hash 值以及 key 是否相同，
     * 如果相同的话，直接覆盖，不相同就通过拉链法解决冲突。
     * <p>
     * 所谓扰动函数指的就是 HashMap 的 hash 方法。
     * 使用 hash 方法也就是扰动函数是为了防止一些实现比较差的 hashCode() 方法 换句话说使用扰动函数之后可以减少碰撞。
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    // 默认初始容量是16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;


    transient int size;

    transient int modCount;

    int threshold;

    transient Node<K,V>[] table;


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public V setValue(V value) {
            return null;
        }

        // 重写 equals() 方法
        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    public V put(K key, V value) {
        return null;
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        Node<K, V>[] tab;
        Node<K, V> p;
        int n, i;
        if ((tab = table) == null || (n = tab.length) == 0) {
        }
        return null;
    }

}
