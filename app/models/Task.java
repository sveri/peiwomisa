package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Task extends Model {

	private static final long serialVersionUID = 6735740220110988660L;

	@Id
	public Long id;

	@Column(columnDefinition = "boolean default false")
	private boolean done;

	private String name;

	private String description;

	private Date dueTo;

	@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

//	@OneToOne
//	private User user;

	public static Model.Finder<Long, Task> find = new Model.Finder(Long.class,
			Task.class);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueTo() {
		return dueTo;
	}

	public void setDueTo(Date dueTo) {
		this.dueTo = dueTo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	@Override
	public String toString() {
		return getName() + ": " + getDescription();
	}

}
