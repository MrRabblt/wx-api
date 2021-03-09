package cn.hmxz.modules.lit.enumType;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:04
 * @FileName: AdType
 * @Description: 广告类型
 */
public enum StatusType {
    /**
     * 生效
     */
    ACTIVE("Active","Active"),
    /**
     * 简历精修
     */
    INACTIVE("inactive","inactive");
    private String code;
    private String name;

    StatusType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
