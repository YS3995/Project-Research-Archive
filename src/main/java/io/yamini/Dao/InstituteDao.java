package io.yamini.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.yamini.Model.Institute;
import io.yamini.Model.User;
import io.yamini.repo.InstituteRepo;
import io.yamini.repo.UserRepo;
@Service
public class InstituteDao {
	
	@Autowired
	private InstituteRepo instituteRepo;
	 
	public void saveInstitute(Institute inst) {
		instituteRepo.save(inst);
		
	}
	
	public  List<Institute> getAllInstitutes() {
		// TODO Auto-generated method stub
		System.out.print("enterin gdao");
		List<Institute> temp = new ArrayList<>();
		instituteRepo.findAll().forEach(temp::add);
		return temp;
		
	}
		
	public Institute getInstituteById(Long id) {
		System.out.println("asdfasdfaskdhflslakfjh");  
			
		Institute ins=instituteRepo.findById(id).orElse(null);
		System.out.print(ins.toString());
		return ins;
		
	}

	
}
