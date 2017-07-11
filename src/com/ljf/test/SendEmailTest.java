package com.ljf.test;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.swing.DebugGraphics;

public class SendEmailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// //收件人邮箱
		// String to = "1213199142@qq.com";
		//
		// //发件人邮箱
		// String from = "3067418132@qq.com";
		//
		// //发送邮件的主机
		// String host = "smtp.qq.com";
		//
		// //获取系统的属性
		// Properties properties = System.getProperties();
		//
		// //设置邮件服务地址
		// properties.setProperty("mail.smtp.host", host);
		//
		// //获取默认的对话session对象
		// Session session = Session.getDefaultInstance(properties);
		//
		// try {
		// //创建默认的MimeMessage对象
		// MimeMessage message = new MimeMessage(session);
		//
		// //set from:头部头字段
		// message.setFrom(new InternetAddress(from));
		//
		// //set to ：头部头字段
		// message.addRecipient(Message.RecipientType.TO, new
		// InternetAddress(to));
		//
		// //set subject：头部头字段
		// message.setSubject("This is the subject line");
		//
		// //设置消息主体
		// message.setText("you are good,just do it");
		//
		// //发送消息
		// Transport.send(message);
		// System.out.println("发送成功");
		// } catch (MessagingException e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// 创建Properties 类用于记录邮箱的一些属性
		final Properties props = new Properties();
		// 表示SMTP发送邮件，必须进行身份验证
		props.put("mail.smtp.auth", "true");
		// 此处填写SMTP服务器
		props.put("mail.smtp.host", "smtp.qq.com");
		// 端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
		props.put("mail.smtp.port", "587");
		// 此处填写你的账号
		props.put("mail.user", "3067418132@qq.com");
		// 此处的密码就是前面说的16位STMP口令
		props.put("mail.password", "hqeqisnabgdxdhdg");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);

		mailSession.setDebug(true);
		try {
			// 创建邮件消息
			MimeMessage message = new MimeMessage(mailSession);
			// 设置发件人
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);
			// 设置收件人的邮箱

			String[] receiverAddr = { "1213199142@qq.com", "2636521258@qq.com" };
			for (int i = 0; i < receiverAddr.length; i++) {
				InternetAddress to = new InternetAddress(receiverAddr[i]);
				message.addRecipient(RecipientType.TO, to);
			}

			// 设置邮件标题
			message.setSubject("邮件");

			// 添加附件消息
			String filename1 = "D:/EclipseWorkspace/javaTest/src/file.txt";
			MimeBodyPart body1 = new MimeBodyPart();
			body1.setDataHandler(new DataHandler(new FileDataSource(filename1)));
			body1.setFileName(MimeUtility.encodeText("file.txt"));

			String filename2 = "D:/EclipseWorkspace/javaTest/src/file2.txt";
			MimeBodyPart body2 = new MimeBodyPart();
			body2.setDataHandler(new DataHandler(new FileDataSource(filename2)));
			body2.setFileName(MimeUtility.encodeText("file2.txt"));
			// // 创建消息部分
			// BodyPart messageBodyPart = new MimeBodyPart();
			//
			// // 消息
			// messageBodyPart.setText("This is message body");

			// 创建多重消息
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body1);
			multipart.addBodyPart(body2);
			message.setContent(multipart,"text/html;charset=UTF-8");
			//
			// // 设置文本消息部分
			// multipart.addBodyPart(messageBodyPart);
			//
			// // 附件部分
			// messageBodyPart = new MimeBodyPart();
			// String filename = "D:/EclipseWorkspace/javaTest/src/file.txt";
			// DataSource source = new FileDataSource(filename);
			// messageBodyPart.setDataHandler(new DataHandler(source));
			// messageBodyPart.setFileName(filename);
			// multipart.addBodyPart(messageBodyPart);

			// 设置邮件的内容体
			// message.setText("123456");
			// message.setContent("132","C:/Users/lijianfu/Desktop/越秀正负面清单信息管理平台.txt");

			// 最后当然就是发送邮件啦
			Transport.send(message, message.getAllRecipients());
			System.out.println("发送成功！");

		} catch (MessagingException | UnsupportedEncodingException mes) {
			mes.printStackTrace();
		}
	}

}
