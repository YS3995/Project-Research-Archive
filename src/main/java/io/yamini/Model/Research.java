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

public class Research {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rId;
	private String researchName;
	private String researchPaperLocation;
	private String description;
	private LocalDateTime date;

	public Research() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Research(Long rId, String researchName, String researchPaperLocation, String description) {
		super();
		this.rId = rId;
		this.researchName = researchName;
		this.researchPaperLocation = researchPaperLocation;
		this.description = description;
	}

	public Long getrId() {
		return rId;
	}

	public void setrId(Long rId) {
		this.rId = rId;
	}

	public String getResearchName() {
		return researchName;
	}

	public void setResearchName(String researchName) {
		this.researchName = researchName;
	}

	public String getResearchPaperLocation() {
		return researchPaperLocation;
	}

	public void setResearchPaperLocation(String researchPaperLocation) {
		this.researchPaperLocation = researchPaperLocation;
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