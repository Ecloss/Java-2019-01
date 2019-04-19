package java_util.code;

import java.util.*;

/**
 * Hash测试
 *
 * @author 余修文
 * @date 2019/4/17 17:17
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println("----------直接输出HashMap-------------------");
        System.out.println(map);

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + "  ");
        }
        System.out.println();
        Collection<String> values = map.values();
        values.stream().forEach(str -> System.out.print(str + "  "));
        System.out.println();

        System.out.println("---------------------第三种方法循环遍历KeyValue--------------------------");
        Set<String> keys2 = map.keySet();
        for (String key : keys2) {
            System.out.println(key + ":  " + map.get(key) + "  ");
        }

        System.out.println("----------------------第四种方法循环遍历-----------------------");
        Set<java.util.Map.Entry<String, String>> entries = map.entrySet();
        for (java.util.Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }

        System.out.println("after map.size = " + map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.remove("san"));
        System.out.println(map);
        System.out.println(map.get("si"));
        System.out.println(map.containsKey("si"));
        System.out.println(map.containsValue("李四"));
        System.out.println(map.replace("si", "李四2"));

        System.out.println("----------处理后输出HashMap-------------------");
        System.out.println(map);


    }

}
