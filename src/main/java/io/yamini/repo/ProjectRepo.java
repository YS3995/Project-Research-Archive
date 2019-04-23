package io.yamini.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.yamini.Model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long >{
	
	/*
	 * @Query("SELECT p.topic_id FROM project p where p.p_id = :id") Long
	 * findTopicById1(@Param("id") Long id);
	 * 
	 * Long findById1(Long id);
	 */
}



