package io.yamini.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.yamini.Dao.CourseDao;
import io.yamini.Dao.InstituteDao;
import io.yamini.Model.Course;
import io.yamini.Model.Institute;

@RestController
public class CourseController {
      @Autowired
	  private CourseDao courseService;
	
      @Autowired
	  private InstituteDao instituteService;

	@RequestMapping(method = RequestMethod.POST, value = "/addCourse")
	public Course saveCourse(@RequestBody Course course) {

		courseService.saveCourse(course);
		return course;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addCourse/{iId}")
	public Course addCourse(@RequestBody Course course, @PathVariable Long iId) {
		System.out.println(iId + " " + iId + " " + course.toString());

		Institute inst = instituteService.getInstituteById(iId);

		List<Course> courseList = inst.getCourses();
		courseList.add(course);
		inst.setCourses(courseList);
		//instituteService.saveInstitute(inst);
		courseService.saveCourse(course);

		return course;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/allCourses")
	public List<Course> getallCourse() {
		System.out.println("entering in  allCourse");

		return courseService.getAllCourse();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listCoursesByInstitute/{id}")
	public List<Course> getCourseByInst(@PathVariable Long id) {

		Institute  inst = instituteService.getInstituteById(id);

		return inst.getCourses();
	}
}

