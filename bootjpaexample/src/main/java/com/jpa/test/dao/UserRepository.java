package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entity.Users;

public interface UserRepository extends CrudRepository<Users, Integer>{
	
	public List<Users> findByName(String name);
	
	public List<Users> findByCity(String city);
	
	public List<Users> findByNameAndCity(String name,String city);
	
	//Using @Query Annotation
	
	@Query("select u FROM Users u")
	public List<Users> getAllUser();
	
	//Parameterized Query
	
	@Query("Select u from Users u where u.name=:n")
	public List<Users> getUserByName(@Param("n")String name);
	
	@Query("Select u from Users u where u.name=:n and u.city=:c")
	public List<Users> getUserByNameAndCity(@Param("n")String name,@Param("c")String city);
	
	//Native Query
	@Query(value="Select * from Users",nativeQuery=true)
	public List<Users> getUsers();
	
}
