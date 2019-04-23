package io.yamini.Dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.yamini.Model.Project;
import io.yamini.Model.ProjectTopic;
import io.yamini.Model.User;
import io.yamini.repo.ProjectRepo;
import io.yamini.repo.ProjectTopicRepo;
import io.yamini.repo.UserRepo;

@Service
public class ProjectDao {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private ProjectTopicRepo projectTopicRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		System.out.print("enterin gdao");
		List<Project> temp = new ArrayList<>();
		projectRepo.findAll().forEach(temp::add);
        System.out.print(temp);
		
		return temp;
	}

	public void addProject(Project pro, ProjectTopic pt, User us) {
		// TODO Auto-generated method stub
		List<Project> pList = pt.getProjects();
		pList.add(pro);
		pt.setProjects(pList);
		
		pList = us.getProjects();
		pList.add(pro);
		us.setProjects(pList);
		
		projectRepo.save(pro);
		
	}
	
	public List<Project> getByTopicId(Long id) {
		
		ProjectTopic pTopic = projectTopicRepo.findById(id).orElse(null);
		List<Project> pList = new ArrayList<Project>();
		pList = pTopic.getProjects();

		return pList;
	}
	
	public List<Project> getByRoll(String roll) {
		
		User user = userRepo.findById(roll).orElse(null);
		List<Project> pList = new ArrayList<Project>();
		pList = user.getProjects();
		return pList;
	}

	public Project getById(Long id) {
		// TODO Auto-generated method stub
		Project pro = projectRepo.findById(id).orElse(null);
		return pro;
	}

}
