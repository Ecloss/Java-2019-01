package other.other2019_02.inherit;

/**
 * 恋人，继承人这个父类
 *
 * @author 余修文
 * @date 2019/2/15 9:36
 */
public class LoversPeople extends People {

    private Integer address;

    public LoversPeople(String name, Integer address) {
        super(name);
        this.address = address;
    }

    public LoversPeople(Integer address) {
        this.address = address;
    }

    public LoversPeople(String name, Integer age, String[] interest, Integer address) {
        super(name, age, interest);
        this.address = address;
    }



    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }
}
