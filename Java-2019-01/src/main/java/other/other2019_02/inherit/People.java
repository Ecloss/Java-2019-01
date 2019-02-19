package other.other2019_02.inherit;

/**
 * 人，基类
 *
 * @author 余修文
 * @date 2019/2/15 9:36
 */
public class People {

    String name;

    Integer age;

    String[] interest;

    public People(String name, Integer age, String[] interest) {
        this.name = name;
        this.age = age;
        this.interest = interest;
    }

    public People(String name) {
        this.name = name;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getInterest() {
        return interest;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }
}
