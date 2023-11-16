package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.Users;


@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		Users user =new Users();
//		user.setCity("Pune");
//		user.setName("Abhishek Kumar");
//		user.setStatus("Javaaaaa");
		
		Users user1 =new Users();
		user1.setCity("Pune");
		user1.setName("Akas Kumar");
		user1.setStatus("Python");
		
		Users user2 =new Users();
		user2.setCity("Ranchi");
		user2.setName("Rohan");
		user2.setStatus("GoLang");
		
		//1-Saving single user
//		Users user =userRepository.save(user2);
//		System.out.println(user2);
		
		//2-Save multiple objects
//		List<Users> users = List.of(user1,user2);
//		Iterable<Users> result = userRepository.saveAll(users);
//		
//		result.forEach(user ->{
//			System.out.println(user);
//		});
//		
//		System.out.println("DOne");
		
		
		//3-Update the user based on id
//		Optional<Users> optional = userRepository.findById(2);
//		
//		Users user = optional.get();
//		System.out.println(user);
//		
//		user.setName("Mana ali");
//		Users res = userRepository.save(user);
//		
//		System.out.println(res);
		
		
		//4-Get user
		
		Iterable<Users> itr = userRepository.findAll();	
		System.out.println("All user data");
		itr.forEach(user->System.out.println(user));
		
		//5-Delete
//		userRepository.deleteById(2);
//		System.out.println("Deleted");
//		Iterable<Users> itr = userRepository.findAll();	
//		itr.forEach(user->System.out.println(user));
		
//		userRepository.deleteAll(itr);//It will delete all user data
		
/*-------------Derived Query Methods-------------------*/		
		System.out.println("******************************************");
		System.out.println("Using Derived Query Methods");
		//findByName
		System.out.println("Find By Name");
		List<Users> userData = userRepository.findByName("Rohan");
		//System.out.println(userData);
		
		userData.forEach(e -> System.out.println(e));
		
		System.out.println("******************************************");
		
		List<Users> userCityData = userRepository.findByCity("Ranchi");
		//System.out.println(userCityData);
		
		userCityData.forEach(e -> System.out.println(e));
		
		System.out.println("******************************************");
		System.out.println("Find By Name And City");
		
		List<Users> findByNameAndCity = userRepository.findByNameAndCity("Abhishek Kumar", "Pune");
		if(findByNameAndCity==null) {
			System.out.println("User data is not present");
		}
		else {
			System.out.println(findByNameAndCity);
		}
		
		
		
		//Query
		System.out.println("Using Query");
		List<Users> allUser = userRepository.getAllUser();	
		
		allUser.forEach(user->System.out.println(user));
		
		System.out.println("Using Parameterized Query");
		List<Users> userByName = userRepository.getUserByName("John");
		
		userByName.forEach(e->System.out.println(e));
		
		System.out.println("Get user by name and city");
		System.out.println(userRepository.getUserByNameAndCity("Rohan", "Ranchi"));
		
		System.out.println("using Native Query");
		List<Users> users = userRepository.getUsers();
		users.forEach(e->System.out.println(e));
	}
}
