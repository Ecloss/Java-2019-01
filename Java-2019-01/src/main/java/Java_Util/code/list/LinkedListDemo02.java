package Java_Util.code.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * LinkedList源码解析
 *
 * @author 余修文
 * @date 2019/2/28 11:34
 */
public class LinkedListDemo02 {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(0);
        /* 在列表结尾添加元素 */
        linkedList.add(1);
        linkedList.add(1, 3);
        linkedList.add(3);
        System.out.println("LinkedList （直接输出的）：" + linkedList);
        /* 返回此列表的第一个元素 */
        System.out.println("getFirst() 获得的第一个元素：" +linkedList.getFirst());
        /* 返回此列表的最后一个元素 */
        System.out.println("getLast() 获得最后一个元素：" + linkedList.getLast());
        /* 移除第一个元素 */
        System.out.println("removeFirst 删除第一个元素并返回：" + linkedList.removeFirst());
        /* 移除最后一个元素 */
        System.out.println("removeLast 删除最后一个元素并返回：" + linkedList.removeLast());
        /* 判断是否包含某个特定的元素 */
        System.out.println("contains 方法判断列表是否包含某个元素：" + linkedList.contains(1));
        System.out.println("LinkedList （操作后的）：" + linkedList);
        /* 返回LinkedList的大小 */
        System.out.println("LinkedList的大小：" + linkedList.size());

        /*----------------------------------位置访问操作----------------------------------------*/
        System.out.println("--------------------------------------");
        linkedList.set(1, 5);
        System.out.println("After set(1, 3)：" + linkedList);
        System.out.println("get(1) 获得指定位置的元素：" + linkedList.get(1));

        /************************** Search操作 ************************/
        System.out.println("---------------------------------------");
        /* 返回此列表中首次出现此元素的位置 */
        System.out.println("indexOf(5):" + linkedList.indexOf(5));
        linkedList.add(3);
        linkedList.add(5);
        System.out.println("lastIndexOf(5)： " + linkedList.lastIndexOf(5));

        /************************** Queue操作 ************************/
        System.out.println("----------------------------------");
        System.out.println("LinkedList （直接输出的）：" + linkedList);
        /* 获取但不移除此列表的头 */
        System.out.println("peek()：" + linkedList.peek());
        /* 获取但不移除此列表的头 */
        System.out.println("element()：" + linkedList.element());
        /* 获取并移除此列表的头 */
        linkedList.poll();
        System.out.println("After poll()：" + linkedList);
        /* 删除并移除此列表的头 */
        linkedList.remove();
        System.out.println("After remote()：" + linkedList);
        /* 将指定元素添加到此列表的末尾 */
        linkedList.offer(4);
        System.out.println("After offer：" + linkedList);
        linkedList.addLast(6);
        System.out.println("After addLast(): " + linkedList);

        /************************** Deque操作 ************************/
        System.out.println("--------------------------------------");
        /* 在此列表的开头插入指定的元素 */
        linkedList.offerFirst(2);
        System.out.println("After offerFirst(2): " + linkedList);
        /* 在此列表末尾添加指定的元素 */
        linkedList.offerLast(5);
        System.out.println("After offerLast(5): " +linkedList);
        /* 获取但不移除第一个元素 */
        System.out.println("peekFirst(): " + linkedList.peekFirst());
        /* 获取但不移除最后一个元素 */
        System.out.println("peekLast(): " + linkedList.peekLast());
        /* 获取并且移除第一个元素 */
        linkedList.pollFirst();
        System.out.println("After pollFirst()：" + linkedList);
        /* 获取并且删除最后一个元素 */
        linkedList.pollLast();
        System.out.println("After pollLast()：" + linkedList);
        /* 将元素推入到此列表所表示的堆栈（插入到列表的头） */
        linkedList.push(2);
        System.out.println("After push(2): " + linkedList);
        /* 从此列表所表示的堆栈处弹出一个元素（获取并移除列表第一个元素） */
        linkedList.pop();
        System.out.println("After pop(): " + linkedList);
        linkedList.add(3);
        System.out.println("LinkedList:" + linkedList);
        /* 从列表删除第一次出现的指定元素（从头到尾部全部遍历） */
        linkedList.removeFirstOccurrence(3);
        System.out.println("After removeFirstOccurrence(3)：" + linkedList);
        /* 从列表删除最后一次出现的指定元素（从头到尾全部遍历） */
        linkedList.removeLastOccurrence(3);
        System.out.println("After removeFirstOccurrence(3):  " + linkedList);

        /************************** 遍历操作 ************************/
        System.out.println("-----------------------------------------");
        linkedList.clear();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        /* 迭代器遍历 */
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("Iterator: " + (end - start) + "ms");

        /* 顺序遍历（随机遍历） */
        start = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println("for:  " + (end - start) + "ms");

        // 另一种for循环遍历
        start = System.currentTimeMillis();
        for (Integer i : linkedList) {

        }
        end = System.currentTimeMillis();
        System.out.println("for2:  " + (end - start) + " ms");

        /* 通过pollFirst() 或 pollLast() 来遍历LinkedList */
        LinkedList<Integer> temp1 = new LinkedList<>();
        temp1.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp1.size() != 0) {
            temp1.pollFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("After pollFirst() 或 pollLast():  " + (end - start) + "ms");

        // 通过removeFirs()  或removeLast() 来遍历LinkedList
        LinkedList<Integer> temp2 = new LinkedList<>();
        temp2.addAll(linkedList);
        start = System.currentTimeMillis();
        while (temp2.size() != 0) {
            temp2.removeFirst();
        }
        end = System.currentTimeMillis();
        System.out.println("removeFirst 或 removeLast() : " + (end - start) + " ms");

    }

}
