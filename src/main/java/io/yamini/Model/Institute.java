

package io.yamini.Model;



import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Entity

public class Institute {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long instituteId;
	private String instituteName;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Institute_Course", 
        joinColumns = { @JoinColumn(name = "instituteId") }, 
        inverseJoinColumns = { @JoinColumn(name = "courseId") }
    )
    List<Course> courses = new ArrayList<Course>();
    
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="instituteId")
	List<User> users = new ArrayList<User>();
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Institute [instituteId=" + instituteId + ", instituteName=" + instituteName + ", courses=" + courses
				+ ", users=" + users + "]";
	}

	
	
	
}
