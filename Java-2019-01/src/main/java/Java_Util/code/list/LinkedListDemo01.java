package Java_Util.code.list;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList 源码深入
 *
 * @author 余修文
 * @date 2019/2/28 10:47
 */
public class LinkedListDemo01<E> {

    /**
     * LinkedList是一个实现了List接口和Deque接口的双端链表。
     * LinkedList底层的链表结构使它支持高效的插入和删除操作，
     * 另外它实现了Deque接口，使得LinkedList类也具有队列的特性;
     * LinkedList不是线程安全的，如果想使LinkedList变成线程安全的，
     * 可以调用静态类Collections类中的synchronizedList方法：
     */
    @Test
    public void demo01() {
        /* 让LinkedList变得线程安全 */
        List list = Collections.synchronizedList(new LinkedList<>());
    }

    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient Node<E> last;

    protected transient int modCount = 0;

    /**
     * 构造方法
     */
    public LinkedListDemo01(Collection<? extends E> c) {
    }

    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
