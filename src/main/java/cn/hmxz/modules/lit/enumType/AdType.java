package cn.hmxz.modules.lit.enumType;

/**
 * @Author: zhengying
 * @Date: 2020/12/19 17:04
 * @FileName: AdType
 * @Description: 广告类型
 */
public enum AdType {
    /**
     * 轮播广告
     */
    ROUND_ROBIN_ADVERTISING("round robin advertising","round robin advertising"),
    /**
     * 简历精修
     */
    RESUME_REFINEMENT("resume refinement","resume refinement"),
    /**
     * 面试辅导
     */
    INTERVIEW_GUIDANCE("interview guidance","interview guidance");
    private String code;
    private String name;

    AdType(String code, String name) {
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
