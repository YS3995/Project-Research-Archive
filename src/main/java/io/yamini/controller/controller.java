package io.yamini.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.yamini.Dao.UserDao;
import io.yamini.Model.User;
import io.yamini.repo.UserRepo;

@Controller

public class controller {

	@Autowired
	private UserRepo use;
	
	@RequestMapping("/projectsByTopic")
	public String projectsByTopic() {

		return "projectsByTopic";
	}
	
	@RequestMapping("/researchesByTopic")
	public String researchesByTopic() {

		return "researchesByTopic";
	}
	
	@RequestMapping("/login")
	public String loginpage() {

		return "login";
	}

	@RequestMapping("/viewProject")
	public String viewProject() {

		return "viewProject";
	}

	@RequestMapping("/viewResearch")
	public String viewResearch() {

		return "viewResearch";
	}

	@RequestMapping("/home")
	public String home() {

		return "home";
	}

	@RequestMapping("/addProject")
	public String addProject() {
		return "addProject";

	}

	@RequestMapping("/addProjectTest")
	public String addProjectTest() {

		return "addProjectTest";

	}

	@RequestMapping("/footer")
	public String footer() {

		return "footer";

	}

	@RequestMapping("/addResearch")
	public String addResearch() {

		return "addResearch";

	}

	@RequestMapping("/header")
	public String header() {

		return "header";

	}

	@RequestMapping("/institute")
	public String institute() {

		return "institute";

	}

	@RequestMapping("/register")
	public String register() {

		return "register";

	}

	@RequestMapping("/testpage")
	public String testpage() {

		return "test";

	}

	@RequestMapping("/testpage2")
	public String testpage2() {

		return "test2";

	}

	@PostMapping("/save-user")
	public String registerUser(@RequestBody User user) {
		use.save(user);
		// request.equals("home");
		System.out.print("asd");
		return "test";
	}

	@RequestMapping("/logincheck")
	public String logincheck() {

		return "logincheck";

	}

}
