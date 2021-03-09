package cn.hmxz.modules.lit.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户足迹表(UserHistory)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:09
 */
@Builder
@Data
public class UserHistory implements Serializable {
    private static final long serialVersionUID = -74819787561591425L;
    /**
     * 足迹id
     */
    private Long hisId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 关联的类型id
     */
    private Long relatedId;
    /**
     * 关联的类型：salary/exp
     */
    private String relatedType;
    /**
     * 创建时间
     */
    private Date createTime;
}