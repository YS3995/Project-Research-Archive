package io.yamini.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity

public class ResearchTopic {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long topicId;
	private String topicName;

	@OneToMany
	@JoinColumn(name="topicId")
	List<Research> research = new ArrayList<Research>();
	
	public List<Research> getResearch() {
		return research;
	}

	public void setResearch(List<Research> research) {
		this.research = research;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	
	
}
