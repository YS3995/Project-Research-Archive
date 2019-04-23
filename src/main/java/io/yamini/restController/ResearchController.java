package io.yamini.restController;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.yamini.Dao.ResearchDao;
import io.yamini.Dao.ResearchTopicDao;
import io.yamini.Dao.UserDao;
import io.yamini.Model.Project;
import io.yamini.Model.Research;
import io.yamini.Model.ResearchTopic;
import io.yamini.Model.User;

@RestController
public class ResearchController {

	private static String UPLOADED_FOLDER_PAPER = "/home/yamini/speProject/ProjectManagement/projectmanagment/src/main/webapp/researches/";

	@Autowired
	private ResearchDao researchService;

	@Autowired
	private ResearchTopicDao rTopicService;

	@Autowired
	private UserDao userService;

	@RequestMapping(method = RequestMethod.GET, value = "/allResearches")
	public List<Research> getallResearche() {
		System.out.println("entering in  allResearches");

		return researchService.getAllResearches();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/researchById/{id}")
	public Research getResearchById(@PathVariable Long id) {

		Research res = researchService.getById(id);

		return res;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listResearchesByTopic/{id}")
	public List<Research> getResearchesByTopic(@PathVariable Long id) {

		ResearchTopic rtopic = rTopicService.getById(id);

		return rtopic.getResearch();

	}

	@RequestMapping(method = RequestMethod.GET, value = "/listResearchesByUser/{roll}")
	public List<Research> getResearchListByUser(@PathVariable String roll) {

		User user = userService.getById(roll);

		return user.getResearches();

	}

	private final Logger logger = LoggerFactory.getLogger(ResearchController.class);

	private static String UPLOADED_FOLDER_RESEARCH = "/home/yamini/speProject/ProjectManagement/projectmanagment/src/main/webapp/researches/";
	
	@PostMapping("/addResearch/{uid}/{rtid}")
	public ResponseEntity<?> addResearch(
			@RequestParam("rname") String rname,
			@RequestParam("files") MultipartFile[] uploadfiles,
			@RequestParam("description") String description,
			@PathVariable String uid,
			@PathVariable Long rtid) 
	{
		
		
		
		String paperLocation = UPLOADED_FOLDER_RESEARCH + uid + "_" + uploadfiles[0].getOriginalFilename();

		LocalDateTime date = LocalDateTime.now();
		
		Research research = new Research();
		research.setResearchName(rname);
		research.setDescription(description);
		research.setResearchPaperLocation(paperLocation);
		research.setDate(date);
		
		User user = userService.getById(uid);	
		ResearchTopic researchTopic=rTopicService.getById(rtid);
		
		
		researchService.addResearch(research, researchTopic, user);
		
		
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

			saveUploadedFiles(uploadfiles[0], paperLocation);

			
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

}