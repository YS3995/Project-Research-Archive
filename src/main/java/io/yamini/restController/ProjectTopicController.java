package io.yamini.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.yamini.Dao.ProjectTopicDao;
import io.yamini.Model.ProjectTopic;

@RestController
public class ProjectTopicController {

	
	@Autowired
	private ProjectTopicDao projectTopicService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addProjectTopic")
	public ProjectTopic saveUser(@RequestBody ProjectTopic pt) {

		projectTopicService.addProjectTopic(pt);
		return pt;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllProjectTopic")
	public List<ProjectTopic> getAllProjectTopic() {

		List<ProjectTopic> ptList = projectTopicService.getAllProTopics();
		
		return ptList;
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getProjectTopicById/{id}")
	public ProjectTopic getProjectTopicById(@PathVariable Long id) {

		return projectTopicService.getById(id);
		
	}


}
	
	
	