package io.yamini.Model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity

public class Project {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long pId;
	private String projectName;
	private String readmeLocation;
	private String zipLocation;
	private String description;
	private LocalDateTime date;
	
	public Project(Long pId, String projectName, String readmeLocation, String zipLocation, String description) {
		super();
		this.pId = pId;
		this.projectName = projectName;
		this.readmeLocation = readmeLocation;
		this.zipLocation = zipLocation;
		this.description = description;
	}
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getpId() {
		return pId;
	}
	
	public void setpId(Long pId) {
		this.pId = pId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getReadmeLocation() {
		return readmeLocation;
	}
	
	public void setReadmeLocation(String readmeLocation) {
		this.readmeLocation = readmeLocation;
	}
	
	public String getZipLocation() {
		return zipLocation;
	}
	
	public void setZipLocation(String zipLocation) {
		this.zipLocation = zipLocation;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public void setDate(LocalDateTime date2) {
		this.date = date2;
	}

			
}