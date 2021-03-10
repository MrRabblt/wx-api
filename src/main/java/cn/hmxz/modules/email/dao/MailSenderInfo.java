package cn.hmxz.modules.email.dao;

import lombok.Data;

/**
 * 发送邮件需要使用的基本信息
 */
@Data
public class MailSenderInfo {

    /**
     * 发送邮件的服务器的IP和端口
     */
    private String host;

    /**
     * 邮件发送者的地址
     */
    private String from;

    /**
     * 邮件接收者的地址
     */
    private String[] tos;

    /**
     * 登陆邮件发送服务器的用户名和密码
     */
    private String userName;
    private String password;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件的文本内容
     */
    private String content;

}