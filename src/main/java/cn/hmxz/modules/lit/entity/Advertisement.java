package cn.hmxz.modules.lit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告表(Advertisement)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:25:54
 */
@Data
public class Advertisement implements Serializable {
    private static final long serialVersionUID = -69838285618616618L;
    /**
     * 广告id
     */
    private Long adId;
    /**
     * 广告名称
     */
    private String adName;
    /**
     * 广告描述
     */
    private String adDesc;
    /**
     * 广告链接
     */
    private String adUrl;
    /**
     * 图片链接
     */
    private String adImage;
    /**
     * 跳转类型:活动页/公众号推文
     */
    private String directType;
    /**
     * 广告类型：简历精修/面试辅导/轮播广告
     */
    private String adType;
    /**
     * 广告优先级
     */
    private Integer adPriority;
    /**
     * 创建时间
     */
    private Date createTime;
}