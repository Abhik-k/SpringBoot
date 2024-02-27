package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{
	
}
