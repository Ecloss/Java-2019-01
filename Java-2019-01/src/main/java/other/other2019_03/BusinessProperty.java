package other.other2019_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 余修文
 * @date 2019/3/21 11:47
 */

public enum BusinessProperty implements ContentEnum {

    NONE("无", 0),
    MORTGAGE_RENEWAL("按揭电销", 1),
    COOPERATE_ISSUE("合作出单", 2),
    COOPERATE_RENEWAL("合作续保", 3),
    AGENT("代理业务", 4),
    NORMAL_ELECTRIC("传统电销", 5),
    BRAND_ELECTRIC("品牌电销", 6),
    CAR_CITY("车城业务", 7);

    private String content;
    private Integer value;

    private BusinessProperty(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static BusinessProperty getByValue(Integer value) {
        BusinessProperty[] types = BusinessProperty.values();
        for (BusinessProperty type : types) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

}
