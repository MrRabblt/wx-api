package cn.hmxz.modules.lit.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 表态表(StandMake)实体类
 *
 * @author liangjiang
 * @since 2020-12-27 16:00:07
 */
@Data
@Builder
public class StandMake implements Serializable {
    private static final long serialVersionUID = -88078472562616685L;
    /**
     * 表态id
     */
    private Long standId;
    /**
     * 关联的id
     */
    private Long relatedId;
    /**
     * 关联的类型
     */
    private String relatedType;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 表态类型
     */
    private String standType;
    /**
     * 是否表态
     */
    private Boolean isStand;
    /**
     * 创建时间
     */
    private Date createTime;
}