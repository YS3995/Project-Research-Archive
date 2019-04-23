package io.yamini.restController;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.yamini.Dao.InstituteDao;
import io.yamini.Model.Course;
import io.yamini.Model.Institute;
import io.yamini.Model.Project;
import io.yamini.repo.InstituteRepo;

@RestController

public class InstituteController {

	@Autowired
	private InstituteDao instituteService;

	@RequestMapping(method = RequestMethod.POST, value = "/saveInstitute")
	public Institute saveInstitute(@RequestBody Institute inst) {
		//inst.setInstituteId(null);
		instituteService.saveInstitute(inst);
		
		return inst;

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/allInstitutes")
	public List<Institute> getallInstitute() {
		System.out.println("entering in  allInstitutes");
		
		return  instituteService.getAllInstitutes();
	   
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/instituteById/{id}")
	public Institute getInstituteById(@PathVariable Long id) {

		Institute inst = instituteService.getInstituteById(id);

		return inst;

	}
	
			
	
	
	

}
