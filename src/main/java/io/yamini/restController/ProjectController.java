
package io.yamini.restController;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.yamini.Dao.ProjectDao;
import io.yamini.Dao.ProjectTopicDao;
import io.yamini.Dao.UserDao;
import io.yamini.Model.Project;
import io.yamini.Model.ProjectTopic;
import io.yamini.Model.User;
import io.yamini.repo.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;;

@RestController
public class ProjectController {

	@Autowired
	private ProjectDao projectService;

	@Autowired
	private ProjectTopicDao pTopicService;

	@Autowired
	private UserDao userService;

	/*
	 * @RequestMapping(value = Array(“/{id}”), method = Array(RequestMethod.POST))
	 * def upload(
	 * 
	 * @PathVariable(“id”) id: String,
	 * 
	 * @RequestHeader(“Authorization”) authHeader: String,
	 * 
	 * @RequestParam(“file”) multipartFile: MultipartFile,
	 * 
	 * @RequestParam(“owner_id”) ownerId: String,
	 * 
	 * @RequestParam(“name”) name: String ) = { } Some neat uploading goes on here
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/allProjects")
	public List<Project> getallProject() {
		System.out.println("entering in  allProjects");

		return projectService.getAllProjects();
	}

	// =====================================================================
	// =====================================================

	private final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	private static String UPLOADED_FOLDER_README = "/home/yamini/speProject/ProjectManagement/projectmanagment/src/main/webapp/projects/readme/";
	private static String UPLOADED_FOLDER_ZIP = "/home/yamini/speProject/ProjectManagement/projectmanagment/src/main/webapp/projects/zip/";

	@PostMapping("/addProject/{uid}/{ptid}")
	public ResponseEntity<?> addProject(@RequestParam("pname") String pname,
			@RequestParam("files") MultipartFile[] uploadfiles, @RequestParam("description") String description,
			@PathVariable String uid, @PathVariable Long ptid) {

		String zipLocation = UPLOADED_FOLDER_ZIP + uid + "_" + uploadfiles[1].getOriginalFilename();
		String readmeLocation = UPLOADED_FOLDER_README + uid + "_" + uploadfiles[0].getOriginalFilename();

		LocalDateTime date = LocalDateTime.now();

		Project project = new Project();
		project.setProjectName(pname);
		project.setDescription(description);
		project.setReadmeLocation(readmeLocation);
		project.setZipLocation(zipLocation);
		project.setDate(date);

		User user = userService.getById(uid);
		ProjectTopic projectTopic = pTopicService.getById(ptid);

		projectService.addProject(project, projectTopic, user);

		logger.debug("Multiple file upload!");

		// Get file name
		String uploadedFileName = Arrays.stream(uploadfiles).map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
		System.out.println(uploadedFileName);

		if (StringUtils.isEmpty(uploadedFileName)) {
			System.out.println("entering if");
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {
			System.out.println(Arrays.asList(uploadfiles));

			saveUploadedFiles(uploadfiles[0], readmeLocation);

			saveUploadedFiles(uploadfiles[1], zipLocation);

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - " + uploadedFileName, HttpStatus.OK);

	}

	private void saveUploadedFiles(MultipartFile files, String path) throws IOException {

		System.out.println("entering save file");
		System.out.println(files);

		System.out.println("entering save file");

		byte[] bytes = files.getBytes();

		File file2 = new File(path);

		org.apache.commons.io.FileUtils.writeByteArrayToFile(file2, bytes);

	}

	// =================================================

	@RequestMapping(method = RequestMethod.GET, value = "/listProjectsByTopic/{id}")
	public List<Project> getProjectsByTopic(@PathVariable Long id) {

		ProjectTopic ptopic = pTopicService.getById(id);

		return ptopic.getProjects();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listProjectsByUser/{roll}")
	public List<Project> getProjectListByUser(@PathVariable String roll) {

		User user = userService.getById(roll);

		return user.getProjects();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/projectById/{id}")
	public Project getProjectById(@PathVariable Long id) {

		Project pro = projectService.getById(id);

		return pro;

	}
}
