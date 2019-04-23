package io.yamini.Dao;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yamini.Model.Research;
import io.yamini.Model.ResearchTopic;
import io.yamini.Model.User;
import io.yamini.repo.ResearchRepo;
import io.yamini.repo.ResearchTopicRepo;
import io.yamini.repo.UserRepo;

@Service
public class ResearchDao {
	
	@Autowired
	private ResearchRepo researchRepo;
	
	@Autowired
	private ResearchTopicRepo researchTopicRepo;
	
	@Autowired
	private UserRepo userRepo;
 
	public  List<Research> getAllResearches() {
		// TODO Auto-generated method stub
		System.out.print("enterin gdao");
		List<Research> temp = researchRepo.findAll();
		researchRepo.findAll().forEach(temp::add);
        System.out.print(temp);
		
		return temp;
	}

	public void addResearch(Research res, ResearchTopic rt, User us) {
		// TODO Auto-generated method stub
		List<Research> rList = rt.getResearch();
		rList.add(res);
		rt.setResearch(rList);
		
		rList = us.getResearches();
		rList.add(res);
		us.setResearches(rList);
		
		researchRepo.save(res);
		
	}
	
	
	public List<Research> getByTopicId(Long id) {
		
		ResearchTopic rTopic = researchTopicRepo.findById(id).orElse(null);
		List<Research> rList = new ArrayList<Research>();
		rList = rTopic.getResearch();

		return rList;
	}
	
	public List<Research> getByRoll(String roll) {
		
		User user = userRepo.findById(roll).orElse(null);
		List<Research> rList = new ArrayList<Research>();
		rList = user.getResearches();
		return rList;
	}
	
	public Research getById(Long id) {
		// TODO Auto-generated method stub
		Research res = researchRepo.findById(id).orElse(null);
		return res;
	}



}