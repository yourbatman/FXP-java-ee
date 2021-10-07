package cn.yourbatman.coding.jpa;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * 在此处添加备注信息
 *
 * @author YourBatman. <a href=mailto:yourbatman@aliyun.com>Send email to me</a>
 * @site https://yourbatman.cn
 * @date 2021/10/6 20:26
 * @since 0.0.1
 */
public class JavaMailDemo {

    // =====发送者信息======
    public static final String SENDER_ADDRESS = "641385712@qq.com";
    public static final String SENDER_ACCOUNT = "641385712@qq.com";
    public static final String SENDER_PASSWORD = "xxxxxxxxxxxxx"; // QQ邮箱这里使用授权码登录，而不是密码哦
    public static final String SENDER_QQ_SMTP_SERVER = "smtp.qq.com";
    // =====收件人信息======
    public static final String RECIPIENT_ADDRESS = "yourbatman@aliyun.com";

    /**
     * 发送邮件
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true"); //用户的认证方式
        props.setProperty("mail.transport.protocol", "smtp"); // 传输协议
        props.setProperty("mail.smtp.host", SENDER_QQ_SMTP_SERVER); // 发件人的SMTP服务器地址
        Session session = Session.getInstance(props);
        session.setDebug(true); // 在控制台打印调试信息

        // ======创建一封邮件======
        Message msg = createMimeMessage(session);
        // ======准备发送======
        Transport transport = session.getTransport();
        transport.connect(SENDER_ACCOUNT, SENDER_PASSWORD);
        transport.sendMessage(msg, msg.getAllRecipients()); // 发送邮件（包括）
        //如果只想发送给指定的人，可以如下写法
        //transport.sendMessage(msg, new Address[]{new InternetAddress("xxx@qq.com")});
        transport.close();
    }

    private static MimeMessage createMimeMessage(Session session) throws Exception {
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(SENDER_ADDRESS)); // 设置发件人地址
        /**
         * 设置收件人地址（可以增加多个收件人、抄送、密送），即下面这一行代码书写多行
         * MimeMessage.RecipientType.TO:发送
         * MimeMessage.RecipientType.CC：抄送
         * MimeMessage.RecipientType.BCC：密送
         */
        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(RECIPIENT_ADDRESS));
        msg.setSubject("我是邮件主题", "UTF-8");
        msg.setContent("我是简单的纯文本邮件！", "text/html;charset=UTF-8");
        msg.setSentDate(new Date()); // 邮件的发送时间,默认立即发送
        return msg;
    }


}
