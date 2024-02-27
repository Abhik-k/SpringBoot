package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entities.Courses;
import com.springrest.services.CourseService;

@RestController
public class MyCotroller {

	
	//Object of service class
	@Autowired
	private CourseService courseService;
	
	//Get the Courses
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourses(@PathVariable long courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
