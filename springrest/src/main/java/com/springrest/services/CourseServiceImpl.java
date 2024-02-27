package com.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.entities.Courses;
import com.springrest.repository.CourseDao;
@Service
public class CourseServiceImpl implements CourseService{
	
	//List<Courses> list;
	
//	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Courses(1,"C1","Course 1"));
//		list.add(new Courses(2,"C2","Course 2"));
//	}
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Courses> getCourses() {
//		return list; 
		return courseDao.findAll();
	}

	@Override
	public Courses getCourse(long id) {
		
//		for(Courses c : list) {
//			if(c.getId()==id)
//				return c;
//		}
		
		return courseDao.getOne(id);
	}

	@Override
	public Courses addCourse(Courses course) {
//		list.add(course);
//		return course;
		
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		
//		list.forEach(e->{
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
//		list.forEach(e->{
//			if(e.getId()==courseId) {
//				list.remove(e);
//			}
//		}); 
		
		Courses entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		
	}
	
	
}
