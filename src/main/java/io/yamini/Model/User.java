package io.yamini.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;



@Entity

public class User {

	@Id
	private String rollNo;
	private String name;
	private String password;
	public String getRollNo() {
		return rollNo;
	}
	
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}





	public User(String rollNo, String name, String password) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.password = password;
	}





	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	@OneToMany
	@JoinColumn(name="rollNo")
	List<Project> projects = new ArrayList<Project>();
	
	@OneToMany
	@JoinColumn(name="rollNo")
	List<Research> researches = new ArrayList<Research>();
	
	
	/*@ElementCollection
	@JoinTable(name="Projects",
				joinColumns=@JoinColumn(name="Roll_No")
	)
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="PId") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Project> Projects = new ArrayList<Project>();
	
	@ElementCollection
	@JoinTable(name="Researches",
				joinColumns=@JoinColumn(name="Roll_No")
	)
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="RId") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Research> Researches = new ArrayList<Research>();
*/
	
	
	
	
	
	
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Research> getResearches() {
		return researches;
	}

	public void setResearches(List<Research> researches) {
		this.researches = researches;
	}





	@Override
	public String toString() {
		return "User [rollNo=" + rollNo + ", name=" + name + ", password=" + password + ", projects=" + projects
				+ ", researches=" + researches + "]";
	}

	
	
	
	
	
}
