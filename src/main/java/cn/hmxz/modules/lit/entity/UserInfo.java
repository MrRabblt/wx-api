package cn.hmxz.modules.lit.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:10
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -29692049569969211L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 微信openid
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 黑马号
     */
    private String blackHorseId;
    /**
     * 性别
     */
    private String sex;
    /**
     * 学校
     */
    private String school;
    /**
     * 年级
     */
    private String grades;
    /**
     * 公司名
     */
    private String company;
    /**
     * 岗位
     */
    private String position;
    /**
     * 在职时间
     */
    private String incumbency;
    /**
     * 头像
     */
    private String faceImage;
    /**
     * 创建时间
     */
    private Date createTime;
}