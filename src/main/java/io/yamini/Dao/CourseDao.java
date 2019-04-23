package io.yamini.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.yamini.Model.Course;
import io.yamini.Model.Institute;
import io.yamini.repo.CourseRepo;
@Service
public class CourseDao {

   @Autowired
  private CourseRepo courseRepo;
	
	public void saveCourse(Course course) {
		
		courseRepo.save(course);
	}
	
	public Course getCoursebyId(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	public  List<Course> getAllCourse() {
		
		List<Course> temp = new ArrayList<>();
		courseRepo.findAll().forEach(temp::add);
        System.out.print(temp);
			
		return temp;
	
	}
}
