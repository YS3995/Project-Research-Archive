package io.yamini.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yamini.Model.ProjectTopic;
import io.yamini.repo.ProjectTopicRepo;

@Service
public class ProjectTopicDao {

	@Autowired
	private ProjectTopicRepo projectTopicRepo;
		
	public void addProjectTopic(ProjectTopic pt) {
		
		projectTopicRepo.save(pt);
		
	}
	
	public List<ProjectTopic> getAllProTopics() {
		
		List<ProjectTopic> temp = new ArrayList<>();
		projectTopicRepo.findAll().forEach(temp::add);
	    System.out.print(temp);
			
		return temp;
		
	}
	
	public ProjectTopic getById(Long id) {
		
		ProjectTopic pTopic = projectTopicRepo.findById(id).orElse(null);
		
		return pTopic;

	}
}