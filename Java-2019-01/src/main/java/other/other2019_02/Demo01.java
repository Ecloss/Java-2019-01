package other.other2019_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 余修文
 * @date 2019/3/14 11:04
 */
public class Demo01 {

    public static void main(String[] args) {
        // 通过业务类型添加业务渠道
        for (; ; ) {
            // 通过业务渠道添加所有的名单类型
            for (; ; ) {

            }
        }
    }

    @Test
    public void demo01() {
        List<People> list = new ArrayList<>();
        list.add(new People(1, "Yueel"));
        list.add(new People(2, "B"));
        list.add(new People(3, "C"));
        for (People people : list) {
            if (people.getID().equals(1)) {
                people.setName("CCCCCCC");
            }
        }
        System.out.println(list.toString());
    }

    @Test
    public void demo02() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1234");
        stringBuilder.append("09");
        System.out.println(stringBuilder.toString());
    }

}

class People {

    private Integer ID;

    private String name;

    public People(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public People() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}