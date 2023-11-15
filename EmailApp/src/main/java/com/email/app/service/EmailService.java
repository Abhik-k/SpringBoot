package com.email.app.service;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject,String message,String to) {
		//Variable for gamil host
				boolean flag=false;
				
				String from="abhik290698@gmail.com";
				String host="smtp.gmail.com";
				
				//Get the System Properties
				 Properties properties = System.getProperties();
				 System.out.println("Properties: "+properties);
				 
				//Setting important information to properties object
				properties.put("mail.smtp.host",host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.starttls.enable","true");
				properties.put("mail.smtp.auth", "true");
				
				//Step 1: to get the session object
				Session session= Session.getInstance(properties, new Authenticator() {

					@Override
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new javax.mail.PasswordAuthentication("abhik290698@gmail.com", "mjqs uyrk iygb blco");
					}
				});
				
				session.setDebug(true);
				
				//Step 2 :Compose the message
				MimeMessage m = new MimeMessage(session);
				
				try {
					//from email
					m.setFrom(from);
					
					//adding recepient to message
					m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
					
					//adding subject to message
					m.setSubject(subject);
					
					//adding text to message
					m.setText(message);
					
					
					//send
					
					//Step 3: send the message using Transport class
					Transport.send(m);
					
					System.out.println("Sent successfull.............");
					flag=true;
					
					
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				return flag;
			}
	
	
	public boolean sendAttachEmail(String subject,String message,String to,String path) {
		boolean flag=false;
		String from="abhik290698@gmail.com";
		String host="smtp.gmail.com";
		
		//Get the System Properties
		 Properties properties = System.getProperties();
		 System.out.println("Properties: "+properties);
		 
		//Setting important information to properties object
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth", "true");
		
		//Step 1: to get the session object
		Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new javax.mail.PasswordAuthentication("abhik290698@gmail.com", "mjqs uyrk iygb blco");
			}
		});
		
		session.setDebug(true);
		
		//Step 2 :Compose the message
		MimeMessage m = new MimeMessage(session);
		
		try {
			//from email
			m.setFrom(from);
			
			//adding recepient to message
			m.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			m.setSubject(subject);
			
			//Attachment
			MimeMultipart mimeMultipart = new MimeMultipart();
			//text
			//file
			
			//String path="D:\\Desktop\\Waste\\124.jpg";
			
			MimeBodyPart textMime= new MimeBodyPart();
			MimeBodyPart fileMime=new MimeBodyPart();
			
			try {
				textMime.setText(message);
				
				File file = new File(path);
				fileMime.attachFile(file);
				
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);
				
				m.setContent(mimeMultipart);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			//send
			
			//Step 3: send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent successfull.............");
			flag=true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return flag;
	}
}
