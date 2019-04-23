package io.yamini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.yamini.Model.Course;

public interface  CourseRepo extends JpaRepository<Course, Long >{

}
