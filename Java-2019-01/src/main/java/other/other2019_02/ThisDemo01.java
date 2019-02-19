package other.other2019_02;

import java.util.Date;

/**
 * @author 余修文
 * @date 2019/2/14 15:30
 */
public class ThisDemo01 {

    /**
     * This 代表可以该对象
     * 什么时候使用This呢？
     * this.Xxx 代表调用对象的属性或者方法
     * this.Xxx代表调用该对象的构造函数
     */
    final Integer people = 123;

    private Integer ID;

    private String name;

    private  Date birthday;

    public ThisDemo01(Integer ID, String name, Date birthday) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
    }

    public ThisDemo01() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void see() {
        System.out.println(this.name + "and you ?");
    }

    public ThisDemo01 see(Integer ID) {
        ThisDemo01 demo01 = new ThisDemo01();
        return  demo01;
    }

}

class HelloWorld {
    private Integer ID;
}
