package io.yamini.restController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;
import javax.xml.ws.RequestWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.yamini.Dao.CourseDao;
import io.yamini.Dao.InstituteDao;
import io.yamini.Dao.UserDao;
import io.yamini.Model.Course;
import io.yamini.Model.Institute;
import io.yamini.Model.Project;
import io.yamini.Model.Research;
import io.yamini.Model.User;
import io.yamini.repo.InstituteRepo;
import javassist.tools.web.Viewer;

@RestController

public class UserController {
	@Autowired
	private UserDao userService;

	@Autowired
	InstituteDao instituteService;

	@Autowired
	CourseDao courseService;

	@RequestMapping("/getStudent")
	public ModelAndView getStudent(User user) {
		ModelAndView mv = new ModelAndView();

		mv.addObject("obj", user);
		mv.setViewName("viewExample");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addUser/{iId}/{cId}")
	public User saveUser(@RequestBody User user, @PathVariable Long iId, @PathVariable Long cId) {
		System.out.println(iId + " " + cId + " " + user.toString());

		// instituteDao = new InstituteDao();
		Institute inst = instituteService.getInstituteById(iId);
		System.out.println(inst.toString());
		// courseDao = new CourseDao();
		Course course = courseService.getCoursebyId(cId);
		System.out.println(course.toString());
		
		List<User> userList = inst.getUsers();
		userList.add(user);
		inst.setUsers(userList);

		userList = course.getUsers();
		userList.add(user);
		course.setUsers(userList);

		userService.saveUser(user);

		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getUserById/{roll}")
	public User getUserByRollNo(@PathVariable String roll) {
		User user = userService.getById(roll);
		System.out.println(user.toString());
		return user;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/loginCheck")
	public User loginCheck(@RequestBody User temp) {

		User user = userService.getById(temp.getRollNo());
		System.out.println(user.toString());

		if (user != null) {
			if (user.getPassword().equals(temp.getPassword()))
				return user;
			else {

				System.out.println("user.getPassword().equals(pass)" + user.getPassword().equals(temp.getPassword()));
				return null;
			}
		}

		return null;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listAllProject/{roll}")
	public List<Project> getProjectList(@PathVariable String roll) {
		User user = userService.getById(roll);
		
		return user.getProjects();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listAllResearch/{roll}")
	public List<Research> getResearchList(@PathVariable String roll) {
		User user = userService.getById(roll);
		
		return user.getResearches();
	}

}
