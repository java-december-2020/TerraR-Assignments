package com.trobinson.overflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="answers")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String answer_submitted;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;

	// Questions Relationship
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question_id")
		private Question question;
	
	
	// Constructors
	public Answer() {
	}
	public Answer(Answer answer) {
		this.answer_submitted = answer.answer_submitted;
	}
	public Answer(String answer_submitted) {
		this.answer_submitted = answer_submitted;
	}

	// Methods
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer_submitted() {
		return answer_submitted;
	}
	public void setAnswer_submitted(String answer_submitted) {
		this.answer_submitted = answer_submitted;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer_submitted=" + answer_submitted + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", question=" + question + "]";
	}
	
}

