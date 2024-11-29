package dev.playground;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavaPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaPlaygroundApplication.class, args);
	}

	@Autowired
	private EmailService emailService;

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailService.sendEmailWithAttachment(
				"spring.email.to@gmail.com",
				"Sending you email with attachment",
				"This email has attachment",
				"C:\\Users\\public\\picture.jpeg");
	}

}
