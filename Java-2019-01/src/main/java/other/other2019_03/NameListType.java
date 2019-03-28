package other.other2019_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 余修文
 * @date 2019/3/21 11:48
 */
public enum NameListType implements ContentEnum {
    NONE("无", 0),
    TYPE_A("A类名单", 1),
    TYPE_B("B类名单", 2),
    TYPE_C("C类名单", 3),
    TYPE_D("D类名单", 4),
    NORMAL("普通名单", 5),
    TRADITION("传统名单", 6),
    SINGLE_COMPULSORY("单交强", 7);

    private String content;
    private Integer value;

    private NameListType(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public static NameListType getByValue(Integer value) {
        NameListType[] types = NameListType.values();
        for (NameListType matterType : types) {
            if (matterType.getValue().equals(value)) {
                return matterType;
            }
        }
        return null;
    }

    public static List<NameListType> findAll() {
        return new ArrayList<NameListType>(Arrays.asList(NameListType.values()));
    }
}
