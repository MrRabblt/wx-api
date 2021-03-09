package cn.hmxz.modules.lit.enumType;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:04
 * @FileName: AdType
 * @Description: 广告类型
 */
public enum BusinessType {
    /**
     * 面试经验
     */
    INTERVIEW_EXPERIENCE("interview experience","interview experience"),
    /**
     * 薪资爆料
     */
    SALARY_INFO("salary info","salary info");
    private String code;
    private String name;

    BusinessType(String code, String name) {
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
