package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.User;
import com.example.demo.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepo;

	
	
	/*@Test
	public void testInsertUser() {
		User user = new User();
		
		user.setName("nameTest");
		user.setEmail("emailTest");
		
		userRepo.save(user);
	}*/

	/*
	@Test
	public void testGetUser() {
		User user = userRepo.findById(1).get();
		System.out.println(user.toString());		
		assertEquals("hello", user.getName());
	} 
	*/
/*
	@Test	
	public void testUpdateUser() {
		System.out.println("=== 1번 user 조회 ===");
		User user = userRepo.findById(1).get();
		System.out.println("1번 user: " + user.toString());
		String oldName = user.getName();
		
		System.out.println("=== 1번 user의 name 수정 ===");
		user.setName(oldName + "_updated");
		userRepo.save(user);
		
		assertEquals(oldName+"_updated", user.getName());
	} 
*/
	
	/*
	@Test
	public void testDeleteBoard() {		
		userRepo.deleteById(2);
	}
	*/
	
	
}
