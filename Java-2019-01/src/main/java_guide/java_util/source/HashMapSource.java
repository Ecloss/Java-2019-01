//package java_util.source;
//
//import sun.reflect.generics.tree.Tree;
//
//import javax.swing.tree.TreeNode;
//import java.io.Serializable;
//import java.util.*;
//
///**
// * HashMap源码
// *
// * @author 余修文
// * @date 2019/4/17 11:02
// */
//public class HashMapSource<K, V> extends AbstractMap<K, V>
//        implements Map<K, V>, Cloneable, Serializable {
//
//    private static final long serialVersionUID = -3658123146051498617L;
//
//    /**
//     * 特性：
//     * 1. 允许null作为key 和 value
//     * jdk1.7：数组 + 链表
//     * jdk1.8：数组 + 链表 + 红黑树
//     */
//    // 向左移动4位， 就是16
//    private final int DEFAULT_INITAL_CAPACITY = 1 << 4;
//
//    // 最大容量
//    static final int MAXIMUM_CAPACITY = 1 << 30;
//
//    // 默认的填充因子
//    static final float DEFAULT_LOAD_FACTOR = 0.75f;
//
//    // 当桶（bucket）上的节点数大于这个值时会转成红黑树
//    static final int TREEIFY_THRESHOLD = 8;
//
//    // 当桶（bucket）上的节点小于这个值时会转成链表
//    static final int MIN_TREEIFY_CAPACITY = 64;
//
//    // 存储元素的数组，总是2的幂次倍
//
//    // 每次扩容和更改map结构的计数器
//    transient int modCount;
//
//    // 临界值，当实际大小，超过临界值时，会进行扩容
//    int threshold;
//
//    // 填充因子
//    float loadFactor = 0.75f;
//
//    transient Node<K,V>[] table;
//
//    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
//        return new Node<>(hash, key, value, next);
//    }
//
//    @Override
//    public Set<Entry<K, V>> entrySet() {
//        return null;
//    }
//
//    static final int hash(Object key) {
//        int h;
//        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//
//    static class Node<K, V> implements Map.Entry<K, V> {
//        final int hash;
//        final K key;
//        V value;
//
//        Node<K, V> next;
//
//        public Node(int hash, K key, V value, Node<K, V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        @Override
//        public K getKey() {
//            return key;
//        }
//
//        @Override
//        public V getValue() {
//            return value;
//        }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        @Override
//        public V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        @Override
//        public final boolean equals(Object o) {
//            if (o == this) {
//                return true;
//            }
//            if (o instanceof Map.Entry) {
//                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
//                if (Objects.equals(key, e.getKey()) &&
//                        Objects.equals(value, e.getValue())) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    //static final class TreeNode<K, V> extends java.util.LinkedHashMap.Entry<K, V> {
//    //    TreeNode<K, V> parent;
//    //    TreeNode<K, V> left;
//    //    TreeNode<K, V> right;
//    //    TreeNode<K, V> prev;
//    //    // 判断颜色
//    //    boolean red;
//    //
//    //    TreeNode(int hash, K key, V val, Node<K, V> next) {
//    //        super(hash, key, val, next);
//    //    }
//    //
//    //    final TreeNode<K, V> root() {
//    //        for (TreeNode<K, V> r = this, p; ; ) {
//    //            if ((p = r.parent) == null) {
//    //                return r;
//    //            }
//    //            r = p;
//    //        }
//    //    }
//    //}
//
//    public HashMapSource() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//    }
//
//    public HashMapSource(Map<? extends K, ? extends V> m) {
//        this.loadFactor = DEFAULT_LOAD_FACTOR;
//
//    }
//
//    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
//        int s = m.size();
//        if (s > 0) {
//            if (table == null) { // pre-size
//                float ft = ((float)s / loadFactor) + 1.0F;
//                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
//                        (int)ft : MAXIMUM_CAPACITY);
//                if (t > threshold)
//                    threshold = tableSizeFor(t);
//            }
//            else if (s > threshold)
//                resize();
//            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
//                K key = e.getKey();
//                V value = e.getValue();
//                putVal(hash(key), key, value, false, evict);
//            }
//        }
//    }
//
//    static final int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//    final Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;
//        int oldThr = threshold;
//        int newCap, newThr = 0;
//        if (oldCap > 0) {
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                    oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        }
//        else if (oldThr > 0) // initial capacity was placed in threshold
//            newCap = oldThr;
//        else {               // zero initial threshold signifies using defaults
//            newCap = DE;
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                    (int)ft : Integer.MAX_VALUE);
//        }
//        threshold = newThr;
//        @SuppressWarnings({"rawtypes","unchecked"})
//        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
//        table = newTab;
//        if (oldTab != null) {
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K,V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode)
//                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        Node<K,V> loHead = null, loTail = null;
//                        Node<K,V> hiHead = null, hiTail = null;
//                        Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//    //
//    //final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
//    //    Node<K, V>[] tab;
//    //    Node<K, V> p;
//    //    int n, i;
//    //    if ((tab == table) == null || (n = tab.length) == 0) {
//    //        n = (tab = resize()).length;
//    //    }
//    //    if ((p = tab[i = (n - 1) & hash]) == null) {
//    //        tab[i] = newNode(hash, key, value, null);
//    //    } else {
//    //        Node<K, V> e; K k;
//    //        if (p.hash == hash && () && ((k = p.key) == key || (key != null && key.equals(k)))) {
//    //            e = p;
//    //        } else if (p instanceof TreeNode) {
//    //            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//    //        }
//    //    }
//    //}
//    //
//    //final Node<K, V> getNode(int hash, Objects key) {
//    //    Node<K, V> tab;
//    //    Node<K, V> first, e;
//    //    int n; K k;
//    //    if ((tab = table) != null && (n = ((Node<K, V>[]) tab).length > 0) ) {
//    //    }
//    //}
//
//}
