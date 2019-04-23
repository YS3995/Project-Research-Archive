package io.yamini.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.yamini.Dao.ResearchTopicDao;
import io.yamini.Model.ResearchTopic;

@RestController
public class ResearchTopicController {
	
	@Autowired
	private ResearchTopicDao researchTopicService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addResearchTopic")
	public ResearchTopic saveUser(@RequestBody ResearchTopic rt) {

		researchTopicService.addResearchTopic(rt);
		return rt;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllResearchTopic")
	public List<ResearchTopic> getAllResearchTopic() {

		List<ResearchTopic> rtList = researchTopicService.getAllResTopics();
		
		return rtList;
		
	}
}