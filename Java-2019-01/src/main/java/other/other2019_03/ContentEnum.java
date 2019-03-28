package other.other2019_03;

/**
 * @author 余修文
 * @date 2019/3/21 11:47
 */
public interface ContentEnum {
    String getContent();

    Integer getValue();

    default boolean equalsValue(Integer value) {
        return value != null && value.equals(this.getValue());
    }
}

