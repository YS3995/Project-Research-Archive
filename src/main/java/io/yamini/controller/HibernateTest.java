package io.yamini.controller;





import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import io.yamini.Model.*;
import io.yamini.repo.*;

public class HibernateTest {
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private  InstituteRepo instituteRepo;
  @Autowired
  private CourseRepo courseRepo;
 
  
  
  
  
  static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Started...........");
		
		Institute inst = new Institute();
		inst.setInstituteName("Inetrnational Institute of Information Technology, Bangalore");
		
		Course course = new Course();
		course.setCourseName("Computer Science & Engineering");
		
		User user = new User();
		user.setRollNo("MT2018135");
		user.setName("Yamini Sharma");
		user.setPassword("yamini");

		Project proj = new Project();
		proj.setProjectName("Project Management");
		proj.setDescription("Keep Track of projects in iiitb");
		
		Research res = new Research();
		res.setResearchName("Semantic Web");
		res.setDescription("Convert RDBMS into graph database");
		
		ProjectTopic ptopic = new ProjectTopic();
		ptopic.setTopicName("Web Devlopment");
	
		ResearchTopic rtopic = new ResearchTopic();
		rtopic.setTopicName("Data Modeling");
		
		List<Research> researches = rtopic.getResearch();
		researches.add(res);
		rtopic.setResearch(researches);
		
		List<Project> projects = ptopic.getProjects();
		projects.add(proj);
		ptopic.setProjects(projects);
		
		List<Course> courses = inst.getCourses();
		courses.add(course);
		inst.setCourses(courses);
		
		List<User> users = inst.getUsers();
		users.add(user);
		inst.setUsers(users);
		
		List<User> us = course.getUsers();
		us.add(user);
		course.setUsers(us);
		
		List<Project> Proj = user.getProjects();
		Proj.add(proj);
		user.setProjects(Proj);

		List<Research> ress = user.getResearches();
		ress.add(res);
		user.setResearches(ress);

	
		
		System.out.println("Objects Intialized.............");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		System.out.println("Session Configured...........");
		
		Session ses = sf.openSession();
		
		System.out.println("Session opened...........");
		
		
		

		
	}

}
