package Java_Util.code.map;

import java.util.*;

/**
 * HashMap源码解析
 *
 * @author 余修文
 * @date 2019/3/1 10:03
 */
public class HashMapDemo02 {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        // 键不能重复key， 但是value可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println("----------直接输出HashMap------------");
        // 链表的存储不是有序存储的
        System.out.println(map);
        /**
         * 遍历HashMap
         */
        // 1. 获取map中所有的key
        System.out.println("----------------for-each获取所有的键值对---------------");
        Set<String> set = map.keySet();
        for (String str : set) {
            System.out.print(str + "   ");
        }
        System.out.println();
        // 2. 获取map中的所有值
        System.out.println("-------------for-each获取map中所有的值--------------------");
        Collection<String> list = map.values();
        for (String str : list) {
            System.out.print(str + "   ");
        }
        System.out.println();
        // 3. 得到key值，同时得到key值所对应的值
        System.out.println("-------------得到key值同时得到key所对应的值-----------------------");
        Set<String> set1 = map.keySet();
        for (String str : set1) {
            System.out.print(str + ":  " + map.get(str) + "    ");
        }
        /**
         * 另外一种不常用的遍历方式
         */
        System.out.println();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        /**
         * HashMap 其他常用的方法
         */
        System.out.println("------------------------------HashMap 其他常用的方法---------------------");
        System.out.println("after map.size()：" + map.size());
        System.out.println("after map.isEmpty():  " + map.isEmpty());
        System.out.println(map.remove("san"));
        System.out.println("after map.remove():  " + map);
        System.out.println("after map.get(si):  " + map.get("si"));
        System.out.println("after map.containsKey(si):  " + map.containsKey("si"));
        System.out.println("after map.containsValue(李四): " + map.containsValue("李四"));
        System.out.println(map.replace("si", "李四2"));
        System.out.println("after map.replace(si, 李四2):  " + map);
    }

}
