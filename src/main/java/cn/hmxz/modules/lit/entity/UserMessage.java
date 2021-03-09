package cn.hmxz.modules.lit.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复消息表(UserMessage)实体类
 *
 * @author liangjiang
 * @since 2020-12-19 14:26:11
 */
public class UserMessage implements Serializable {
    private static final long serialVersionUID = 924654466579718853L;
    /**
     * 消息id
     */
    private Long msgId;
    /**
     * 关联的文章id：salary_id/exp_id
     */
    private Long relatedId;
    /**
     * 关联的文章内容:salary/exprience
     */
    private String relatedType;
    /**
     * 评论方
     */
    private Long fromUserId;
    /**
     * 被评方
     */
    private Long toUserId;
    /**
     * 消息内容
     */
    private String msgInfo;
    /**
     * 消息状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;


    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }

    public String getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}