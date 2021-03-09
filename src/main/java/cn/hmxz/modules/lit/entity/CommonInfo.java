package cn.hmxz.modules.lit.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zhengying
 * @Date: 2020/12/27 22:24
 * @FileName: CommonInfo
 * @Description: commonInfo
 */
@Data
public class CommonInfo {
    /**
     * 浏览量
     */
    private Long views;
    /**
     * 点赞数
     */
    private Long likes;
    /**
     * 收藏量
     */
    private Long favorites;
    /**
     * 面经状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
}
