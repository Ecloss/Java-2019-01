package java_util;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap源码
 *
 * @author 余修文
 * @date 2019/3/29 12:29
 */
public class HashMapSource<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {


    /**
     * HashMap 存储数据的时候好像会产生哈希碰撞
     * 1. 扰动函数，
     * n/2 的时候是按照位运算符来计算的
     */
    static final int DEFAULT_INITAL_CAPACITY = 1 << 4;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    //
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int UNTREEIFY_THRESHOLD = 6;

    static final int MIN_TREEIFY_CAPACITY = 64;

    //


    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

}
