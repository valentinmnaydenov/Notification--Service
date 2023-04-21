package com.notificationsevice.springboot;

import com.notificationsevice.springboot.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootNotificationServiceApplication {

	@Autowired
	private static EmailService emailService;

	public static void main(String[] args) throws MessagingException {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootNotificationServiceApplication.class, args);

		String senderEmail = "valkatabggaming@gmail.com";
		String appPassword = "xwnmyeqocnnewtzo";
		String recipientEmail = "valkatabggaming@gmail.com";
		String subject = "Test Email";
		String message = "Само ЦСКА.";

		emailService = context.getBean(EmailService.class, senderEmail, appPassword);
		emailService.sendEmail(recipientEmail, subject, message);
		System.out.println("Email sent successfully!");

		// Shutdown the Spring context
		context.close();
	}
}