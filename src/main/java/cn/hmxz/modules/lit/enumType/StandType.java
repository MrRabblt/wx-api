package cn.hmxz.modules.lit.enumType;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:04
 * @FileName: AdType
 * @Description: 广告类型
 */
public enum StandType {
    /**
     * 点赞
     */
    LIKE("like","like"),
    /**
     * 收藏
     */
    FAVORITE("favorite","favorite"),
    /**
     * 可信
     */
    TRUST("trust","trust");
    private String code;
    private String name;

    StandType(String code, String name) {
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
