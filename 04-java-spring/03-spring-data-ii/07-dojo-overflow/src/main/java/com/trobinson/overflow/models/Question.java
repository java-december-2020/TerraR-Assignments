package com.trobinson.overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String question_asked;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	        
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;

	// Answers Relationship
	@OneToMany(cascade=CascadeType.ALL, mappedBy="question")
		private List<Answer> answers;

	// Tags Relationship
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "tags_questions", 
        joinColumns = @JoinColumn(name = "question_id"), 
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
	
    
	// Constructors
	public Question() {
	}
	public Question(String question_asked) {
		this.question_asked = question_asked;
	}
	public Question(String question_asked, List<Answer> answers, List<Tag> tags) {
		this.question_asked = question_asked;
		this.answers = answers;
		this.tags = tags;
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
	public String getQuestion_asked() {
		return question_asked;
	}
	public void setQuestion_asked(String question_asked) {
		this.question_asked = question_asked;
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
	public List<Answer> getAnswer() {
		return answers;
	}
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question_asked=" + question_asked + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", answers=" + answers + ", tags=" + tags + "]";
	}
	
}

