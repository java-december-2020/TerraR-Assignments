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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private String first_name;
    
    @NotBlank
    private String last_name;
    
    @Email
    @NotBlank
    private String email;
        
    @NotBlank
    private String location;
    
    @NotBlank
    private String state;
    
    @NotBlank
    private String password;
    
    @Transient
    @NotBlank
    private String passwordConfirmation;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;
            
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    
    // Host Event Relationship
    @OneToMany(cascade=CascadeType.ALL, mappedBy="host")
    private List<Event> events_hosted;
    

    // Join Event Relationship
    @ManyToMany
    @JoinTable(
    	name="user_events",
    	joinColumns = @JoinColumn(name="user_id"),
    	inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private List<Event> events_joined;

    // Comment Owner Relationship
    @OneToMany(cascade=CascadeType.ALL, mappedBy="commenter")
    private List<Comment> comments_posted;

    
    // Constructors  
    public User() {
	}

	public User(String first_name, String last_name, String email,
			String location, String state, String password,
			String passwordConfirmation, List<Event> events_hosted, List<Event> events_joined,
			List<Comment> comments_posted) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.location = location;
		this.state = state;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.events_hosted = events_hosted;
		this.events_joined = events_joined;
		this.comments_posted = comments_posted;
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
       
	public void addEvents_hosted(Event events_hosted) {
		this.events_hosted.add(events_hosted);
	}

	public void addEvents_joined(Event events_joined) {
		this.events_joined.add(events_joined);
	}
	
	public void addComments_posted(Comment comments_posted) {
		this. comments_posted.add(comments_posted);
	}
	
	
	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Event> getEvents_hosted() {
		return events_hosted;
	}

	public void setEvents_hosted(List<Event> events_hosted) {
		this.events_hosted = events_hosted;
	}

	public List<Event> getEvents_joined() {
		return events_joined;
	}

	public void setEvents_joined(List<Event> events_joined) {
		this.events_joined = events_joined;
	}

	public List<Comment> getComments_posted() {
		return comments_posted;
	}

	public void setComments_posted(List<Comment> comments_posted) {
		this.comments_posted = comments_posted;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", location=" + location + ", state=" + state + ", password=" + password + ", passwordConfirmation="
				+ passwordConfirmation + ", events_hosted=" + events_hosted + ", events_joined=" + events_joined
				+ ", comments_posted=" + comments_posted + "]";
	}

	
	
}
