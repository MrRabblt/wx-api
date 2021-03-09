package cn.hmxz.modules.lit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 校招信息(CampusRecruitmentInfo)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:05
 */
@Data
public class CampusRecruitmentInfo implements Serializable {
    private static final long serialVersionUID = -94135517980220543L;
    /**
     * 校招信息id
     */
    private Long infoId;
    /**
     * 校招信息名
     */
    private String infoName;
    /**
     * 公司名
     */
    private String infoCompany;
    /**
     * 公司简称
     */
    private String companyShortName;
    /**
     * 校招信息图片
     */
    private String infoImage;
    /**
     * 推送地址
     */
    private String infoUrl;
    /**
     * 校招信息优先级
     */
    private Integer infoPriority;
    /**
     * 校招信息状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
}