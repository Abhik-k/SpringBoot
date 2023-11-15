package com.email.app.model;

public class EmailRequest {
	
	private String to;
	private String subject;
	private String message;
	private String path;
	
	public EmailRequest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param to
	 * @param subject
	 * @param message
	 */
	public EmailRequest(String to, String subject, String message) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
	}
	
	public EmailRequest(String to, String subject, String message,String path) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.path=path;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", subject=" + subject + ", message=" + message + "]";
	}
	
	
	
}
