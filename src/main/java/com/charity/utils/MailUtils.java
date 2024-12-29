package com.charity.utils;

import org.slf4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱工具
 * <p>

 *
 * 
 */
public class MailUtils {

    Logger logger = LogUtils.getInstance(MailUtils.class);
    //邮件发送器
    private final JavaMailSenderImpl mailSender;
    private final String fromEmail;

    public MailUtils(JavaMailSenderImpl mailSender, String fromEmail) {
        this.mailSender = mailSender;
        this.fromEmail = fromEmail;
    }

    public String sendCode(String email) {
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setSubject("爱慈善-邮箱验证");
            helper.setText("<h2 >爱慈善公益平台</h2>" +
                    "<h3>邮箱验证<h3/>" +
                    "您收到了来自爱慈善公益平台发送的验证码<br>" +
                    "验证码: <span style='color : red'>" + code + "</span><br>" +
                    "<h5 style='color : red'>如果并非本人操作，请忽略本邮件</h5>", true);
            helper.setFrom(fromEmail);
            helper.setTo(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        logger.info("mimeMessage对象为:" + mimeMessage);
        mailSender.send(mimeMessage);
        return String.valueOf(code);
    }

}
