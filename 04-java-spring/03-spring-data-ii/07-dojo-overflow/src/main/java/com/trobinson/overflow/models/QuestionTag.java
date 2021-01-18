package com.trobinson.overflow.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class QuestionTag {
	
	@NotBlank (message="Question field must not be blank")
	private String question_asked;
	
	@NotBlank (message="Tags field must not be blank")
	@Pattern(regexp = "^([a-z0-9 ]+)$|^([a-z0-9 ]+,\\s*)([a-z0-9 ]+\\s*)$|^([a-z0-9 ]+,\\s*)([a-z0-9 ]+,\\s*)([a-z0-9 ]+\\s*)$", message="Tags must be separated by commas, in lower case, and limited to 3.")
	private String subject;
	
	// Getters and Setters
	
	public String getQuestion_asked() {
		return question_asked;
	}
	public void setQuestion_asked(String question_asked) {
		this.question_asked = question_asked;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject.toLowerCase();
	}
	
}
