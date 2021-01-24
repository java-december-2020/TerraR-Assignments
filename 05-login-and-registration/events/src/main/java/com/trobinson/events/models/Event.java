package com.trobinson.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;
	
	private Date date;
	
    @NotBlank
    private String location;
    
    @NotBlank
    private String state;
		
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	        
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;


	// Host Relationship
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User host;
	
	
	// Comment Relationship
	@OneToMany(cascade=CascadeType.ALL, mappedBy="event")
	private List<Comment> comments;

	
	// Join Relationship
	@ManyToMany
	@JoinTable(
		name="user_events",
		joinColumns = @JoinColumn(name="event_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> joiner;


	// Constructors
	public Event() {
	}

	public Event(String name, Date date, String location, String state, User host,
			List<Comment> comments, List<User> joiner) {
		this.name = name;
		this.date = date;
		this.location = location;
		this.state = state;
		this.host = host;
		this.comments = comments;
		this.joiner = joiner;
	}


	// Other Methods
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

	public void addJoiner(User joiner) {
		this.joiner.add(joiner);
	}
	
	public void addComments(Comment comments) {
		this.comments.add(comments);
	}
	
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<User> getJoiner() {
		return joiner;
	}
	public void setJoiner(List<User> joiner) {
		this.joiner = joiner;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", date=" + date + ", location=" + location + ", state=" + state
				+ ", host=" + host + ", comments=" + comments + ", joiner=" + joiner + "]";
	}
	
	
}
