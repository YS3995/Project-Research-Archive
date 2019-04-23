package io.yamini.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class Course {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;
	private String courseName;
	
	
	@ManyToMany(mappedBy = "courses")
     List<Institute> insts = new ArrayList<Institute>();
	
	
	public List<Institute> getInsts() {
		return insts;
	}

	public void setInsts(List<Institute> insts) {
		this.insts = insts;
	}

	@OneToMany
	@JoinColumn(name="courseId")
	List<User> users = new ArrayList<User>();
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", users=" + users + "]";
	}

		
}
