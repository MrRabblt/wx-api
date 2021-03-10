package cn.hmxz.modules.email.util;

import cn.hmxz.modules.email.dao.MailSenderInfo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendMailUtil {

//    static String HOST = "smtp.163.com"; // smtp服务器
//    static String FROM = "xxx@163.com"; // 发件人地址
//    static String USER = "xxx@163.com"; // 用户名
//    static String PWD = "key123456"; // 163的授权码
//    static String SUBJECT = "手表服务抛异常了"; // 邮件标题
//    static String[] TOS = new String[]{"18888888888@163.com"};

    /**
     * 发送 普通邮件
     */
    public static void send(MailSenderInfo mailSenderInfo) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailSenderInfo.getHost());//设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.auth", "true");  //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        Session session = Session.getDefaultInstance(props);//用props对象构建一个session
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);//用session为参数定义消息对象
        try {
            message.setFrom(new InternetAddress(mailSenderInfo.getFrom()));// 加载发件人地址
            String[] tos = mailSenderInfo.getTos();
            InternetAddress[] sendTo = new InternetAddress[mailSenderInfo.getTos().length]; // 加载收件人地址
            for (int i = 0; i < mailSenderInfo.getTos().length; i++) {
                sendTo[i] = new InternetAddress(tos[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(mailSenderInfo.getFrom()));//设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.setSubject(mailSenderInfo.getSubject());//加载标题
            Multipart multipart = new MimeMultipart();//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            BodyPart contentPart = new MimeBodyPart();//设置邮件的文本内容
            contentPart.setText(mailSenderInfo.getContent());
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);//将multipart对象放到message中
            message.saveChanges(); //保存邮件
            Transport transport = session.getTransport("smtp");//发送邮件
            transport.connect(mailSenderInfo.getHost(), mailSenderInfo.getUserName(), mailSenderInfo.getPassword());//连接服务器的邮箱
            transport.sendMessage(message, message.getAllRecipients());//把邮件发送出去
            transport.close();//关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送 html邮件
     */
    public static void sendHtmlEmail(MailSenderInfo mailSenderInfo) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        //设置主机名
        email.setHostName(mailSenderInfo.getHost());
        email.setSmtpPort(465);
        //设置收件人
        email.addTo(mailSenderInfo.getTos());
        //设置发送用户邮箱和邮件名称
        email.setFrom(mailSenderInfo.getFrom(), mailSenderInfo.getSubject());
        //连接发送邮箱
        email.setAuthentication(mailSenderInfo.getUserName(), mailSenderInfo.getPassword());
        //邮件编码格式
        email.setCharset("UTF-8");
        //设置邮件头部
        email.setSubject(mailSenderInfo.getSubject());
        //设置邮件内容，识别HTML标签
        email.setHtmlMsg(mailSenderInfo.getContent());
        email.send();
    }


    public static void main(String[] args) throws EmailException {
        MailSenderInfo mailSenderInfo = new MailSenderInfo();
        mailSenderInfo.setHost("smtp.163.com");
        mailSenderInfo.setFrom("18875144883@163.com");
        mailSenderInfo.setUserName("18875144883@163.com");
        mailSenderInfo.setPassword("DUXYEAPCRMVZHCWQ");
        String[] tos = {"1984272024@qq.com"};
        mailSenderInfo.setTos(tos);
        mailSenderInfo.setSubject("这是标题");
        mailSenderInfo.setContent("这是正文");
//        send(mailSenderInfo);
        sendHtmlEmail(mailSenderInfo);
    }

}