package io.yamini.Dao;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.yamini.Model.Course;
import io.yamini.Model.Institute;
import io.yamini.Model.Project;
import io.yamini.Model.ProjectTopic;
import io.yamini.Model.User;
import io.yamini.repo.CourseRepo;
import io.yamini.repo.InstituteRepo;
import io.yamini.repo.UserRepo;

@Service
public class UserDao {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private InstituteRepo instituteRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	public void saveUser(User user) {
		userRepo.save(user);

	}

	public User getById(String roll) {

		User user = userRepo.findById(roll).orElse(null);
		return user;
	}
	
	public List<User> getAllUser(){
		// TODO Auto-generated method stub
		System.out.print("enterin gdao");
		List<User> temp = new ArrayList<>();
		userRepo.findAll().forEach(temp::add);
		System.out.print(temp);
				
		return temp;
	}

	public List<User> getByInstituteId(Long id) {
		Institute inst = instituteRepo.findById(id).orElse(null);
		List<User> uList = new ArrayList<User>();
		uList = inst.getUsers();

		return uList;
	}
	
	public List<User> getByCourseId(Long id) {
		Course crs = courseRepo.findById(id).orElse(null);
		List<User> uList = new ArrayList<User>();
		uList = crs.getUsers();

		return uList;
	}
}
