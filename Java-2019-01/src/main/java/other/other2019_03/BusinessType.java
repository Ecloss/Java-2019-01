package other.other2019_03;

/**
 * @author 余修文
 * @date 2019/3/21 11:47
 */
public enum BusinessType implements ContentEnum {
    NONE("无", 0),
    COOPERATION("代理业务", 1),
    PARTNER("按揭业务", 2),
    OB("OB业务", 3),
    CHANNEL("渠道业务", 4);

    private String content;
    private Integer value;

    private BusinessType(String content, Integer value) {
        this.content = content;
        this.value = value;
    }

    public static BusinessType getByValue(Integer value) {
        BusinessType[] types = BusinessType.values();
        for (BusinessType type : types) {
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
