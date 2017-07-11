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
		// //�ռ�������
		// String to = "1213199142@qq.com";
		//
		// //����������
		// String from = "3067418132@qq.com";
		//
		// //�����ʼ�������
		// String host = "smtp.qq.com";
		//
		// //��ȡϵͳ������
		// Properties properties = System.getProperties();
		//
		// //�����ʼ������ַ
		// properties.setProperty("mail.smtp.host", host);
		//
		// //��ȡĬ�ϵĶԻ�session����
		// Session session = Session.getDefaultInstance(properties);
		//
		// try {
		// //����Ĭ�ϵ�MimeMessage����
		// MimeMessage message = new MimeMessage(session);
		//
		// //set from:ͷ��ͷ�ֶ�
		// message.setFrom(new InternetAddress(from));
		//
		// //set to ��ͷ��ͷ�ֶ�
		// message.addRecipient(Message.RecipientType.TO, new
		// InternetAddress(to));
		//
		// //set subject��ͷ��ͷ�ֶ�
		// message.setSubject("This is the subject line");
		//
		// //������Ϣ����
		// message.setText("you are good,just do it");
		//
		// //������Ϣ
		// Transport.send(message);
		// System.out.println("���ͳɹ�");
		// } catch (MessagingException e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// ����Properties �����ڼ�¼�����һЩ����
		final Properties props = new Properties();
		// ��ʾSMTP�����ʼ���������������֤
		props.put("mail.smtp.auth", "true");
		// �˴���дSMTP������
		props.put("mail.smtp.host", "smtp.qq.com");
		// �˿ںţ�QQ��������������˿ڣ�������һ����һֱʹ�ò��ˣ����Ծ͸�����һ��587
		props.put("mail.smtp.port", "587");
		// �˴���д����˺�
		props.put("mail.user", "3067418132@qq.com");
		// �˴����������ǰ��˵��16λSTMP����
		props.put("mail.password", "hqeqisnabgdxdhdg");

		// ������Ȩ��Ϣ�����ڽ���SMTP���������֤
		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// �û���������
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
		Session mailSession = Session.getInstance(props, authenticator);

		mailSession.setDebug(true);
		try {
			// �����ʼ���Ϣ
			MimeMessage message = new MimeMessage(mailSession);
			// ���÷�����
			InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
			message.setFrom(form);
			// �����ռ��˵�����

			String[] receiverAddr = { "1213199142@qq.com", "2636521258@qq.com" };
			for (int i = 0; i < receiverAddr.length; i++) {
				InternetAddress to = new InternetAddress(receiverAddr[i]);
				message.addRecipient(RecipientType.TO, to);
			}

			// �����ʼ�����
			message.setSubject("�ʼ�");

			// ��Ӹ�����Ϣ
			String filename1 = "D:/EclipseWorkspace/javaTest/src/file.txt";
			MimeBodyPart body1 = new MimeBodyPart();
			body1.setDataHandler(new DataHandler(new FileDataSource(filename1)));
			body1.setFileName(MimeUtility.encodeText("file.txt"));

			String filename2 = "D:/EclipseWorkspace/javaTest/src/file2.txt";
			MimeBodyPart body2 = new MimeBodyPart();
			body2.setDataHandler(new DataHandler(new FileDataSource(filename2)));
			body2.setFileName(MimeUtility.encodeText("file2.txt"));
			// // ������Ϣ����
			// BodyPart messageBodyPart = new MimeBodyPart();
			//
			// // ��Ϣ
			// messageBodyPart.setText("This is message body");

			// ����������Ϣ
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body1);
			multipart.addBodyPart(body2);
			message.setContent(multipart,"text/html;charset=UTF-8");
			//
			// // �����ı���Ϣ����
			// multipart.addBodyPart(messageBodyPart);
			//
			// // ��������
			// messageBodyPart = new MimeBodyPart();
			// String filename = "D:/EclipseWorkspace/javaTest/src/file.txt";
			// DataSource source = new FileDataSource(filename);
			// messageBodyPart.setDataHandler(new DataHandler(source));
			// messageBodyPart.setFileName(filename);
			// multipart.addBodyPart(messageBodyPart);

			// �����ʼ���������
			// message.setText("123456");
			// message.setContent("132","C:/Users/lijianfu/Desktop/Խ���������嵥��Ϣ����ƽ̨.txt");

			// ���Ȼ���Ƿ����ʼ���
			Transport.send(message, message.getAllRecipients());
			System.out.println("���ͳɹ���");

		} catch (MessagingException | UnsupportedEncodingException mes) {
			mes.printStackTrace();
		}
	}

}
