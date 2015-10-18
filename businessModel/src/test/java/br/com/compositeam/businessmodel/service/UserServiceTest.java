package br.com.compositeam.businessmodel.service;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.businessmodel.model.User;

public class UserServiceTest {
	
	private String email1;
	private String email2;

	private ClassPathXmlApplicationContext context;
	
	private UserService service;
	@Before
	public void setUp(){
		email1 = "test@gmail.com";
		email2 = "test2@mg.com";
		context = new ClassPathXmlApplicationContext("spring.xml");
		service = context.getBean(UserService.class);
	}
	
	@After
	public void tearDown(){
		context.close();
	}
	@Test
	public void testService() {
		User user = new User();
		user.setEmail(email2);
		user.setPassword("12345");
		service.save(user);
	}
	
	@Test
	public void testGetUser(){
		User user1 = new User();
		user1.setEmail(email1);
		user1.setPassword("12345");
		service.save(user1);
		User user = service.getUser(email1);
		Assert.assertEquals(email1, user.getEmail());
	}

}
