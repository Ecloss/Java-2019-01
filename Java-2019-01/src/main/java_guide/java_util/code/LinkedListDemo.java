package java_util.code;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 余修文
 * @date 2019/4/17 13:58
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.addFirst(0);
        linkedList.add(1, 2);
        linkedList.add(3);
        linkedList.addLast(4);


        linkedList.stream().forEach(i -> System.out.print(i + "  "));
        System.out.println();
        System.out.println("getFirst()：" + linkedList.getFirst());
        System.out.println("getLast()：" + linkedList.getLast());
        System.out.println("removeFirst()：" + linkedList.removeFirst());
        System.out.println("removeLast()：" + linkedList.removeLast());
        System.out.println("After remove：");
        linkedList.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("contains()方法判断列表是否包含1这个元素：" + linkedList.contains(1));
        System.out.println("该linkedList的大小：" + linkedList.size());

        System.out.println("----------------------------------------------------");
        linkedList.set(1, 4);

        System.out.println("get(1) ：" + linkedList.get(1));
        System.out.println();
        linkedList.stream().forEach(i -> System.out.print(i + "  "));
        System.out.println();

        System.out.println("--------------------------------------------------");
        System.out.println("peek()：" + linkedList.peek());
        System.out.println("element()：" + linkedList.element());
        linkedList.poll();
        linkedList.offer(4);
        linkedList.stream().forEach(i -> System.out.print(i + "  "));
        System.out.println();

        System.out.println("-----------------------迭代器---------------------------");
        linkedList.clear();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        long start = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.currentTimeMillis();
        System.out.println("iterator：" + (end - start) + "  ms");
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("for：" + (end1 - start1) + "  ms");

        long start2 = System.currentTimeMillis();
        for (Integer i : linkedList) {

        }
        long end2 = System.currentTimeMillis();
        System.out.println("forEach：" + (end2 - start2) + "  ms");


    }

    @Test
    public void demo01() {
        int i = 13;
        int j = 6;
        System.out.println(i ^ j);
        System.out.println(i & j);
        System.out.println(i | j);
    }

}
