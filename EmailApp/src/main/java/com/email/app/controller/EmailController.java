package com.email.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.app.model.EmailRequest;
import com.email.app.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to demo page";
	}
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
		
		boolean res = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		if(res) {
			return ResponseEntity.ok("Email is sent successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
		}
	}
	
	@PostMapping("/sendattach")
	public ResponseEntity<?> sendAttachEmail(@RequestBody EmailRequest request){
		boolean res = this.emailService.sendAttachEmail(request.getSubject(), request.getMessage(), request.getTo(),request.getPath());
		if(res) {
			return ResponseEntity.ok("Email is sent successfully");
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
		}	}
}
