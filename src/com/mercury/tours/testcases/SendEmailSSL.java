package com.mercury.tours.testcases;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;




public class SendEmailSSL {
	
	
       	
	  public static void execute(String reportFileName) throws Exception {

		  final String username = "username@gmail.com";
		  final String password = "password";

		   Properties props = new Properties();
		  props.put("mail.smtp.starttls.enable", "true");
		  props.put("mail.smtp.ssl.trust","*");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.port", "587");

		   Session session = Session.getInstance(props,
		    new javax.mail.Authenticator() {
		     protected PasswordAuthentication getPasswordAuthentication() {
		      return new PasswordAuthentication(username, password);
		     }
		    });

		   try {

		    Message message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("username@gmail.com"));
		   message.setRecipients(Message.RecipientType.TO,
		     InternetAddress.parse("username@gmail.com"));
		   message.setSubject("Reports Availalbe!");
		   message.setText("Dear Mail Test,"
		     + "\n\n No spam to my email, please!");

		    MimeBodyPart messageBodyPart = new MimeBodyPart();

		    Multipart multipart = new MimeMultipart();

		    messageBodyPart = new MimeBodyPart();
		   String file = "C:\\Users\\User\\workspace\\MercuryTours\\test-output\\html\\index.html";
		   String fileName = reportFileName;
		   DataSource source = new FileDataSource(file + fileName);
		   messageBodyPart.setDataHandler(new DataHandler(source));
		   messageBodyPart.setFileName(fileName);
		   multipart.addBodyPart(messageBodyPart);

		    message.setContent(multipart);
		   System.out.println("Sending");
		   Transport.send(message);
		   System.out.println("Done");
		  } catch (MessagingException e) {
		   throw new RuntimeException(e);
		  }
		 }
	  
	 public static void main(String[] args) {
		
		 try {
			SendEmailSSL.execute("Execution status report");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
		}

