package io.yamini.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yamini.Model.ResearchTopic;
import io.yamini.repo.ResearchTopicRepo;

@Service
public class ResearchTopicDao {
	
	@Autowired
	private ResearchTopicRepo researchTopicRepo;
		
	public void addResearchTopic(ResearchTopic rt) {
		
		researchTopicRepo.save(rt);
		
	}
	
	public List<ResearchTopic> getAllResTopics() {
		
		List<ResearchTopic> temp = new ArrayList<>();
		researchTopicRepo.findAll().forEach(temp::add);
	    System.out.print(temp);
			
		return temp;
		
	}
	
	public ResearchTopic getById(Long id) {
		
		ResearchTopic rTopic = researchTopicRepo.findById(id).orElse(null);
		
		return rTopic;

	}

}