package cn.hmxz.modules.lit.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;

import java.io.Serializable;

/**
 * 面试经验表(InterviewExperience)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:07
 */
@Builder
public class InterviewExperience extends CommonInfo implements Serializable {
    private static final long serialVersionUID = 657471911990921564L;
    /**
     * 经验id
     */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long expId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 面经名字
     */
    private String expName;
    /**
     * 公司名
     */
    private String company;
    /**
     * 岗位
     */
    private String position;
    /**
     * 面经内容
     */
    private String inputText;

    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }
}