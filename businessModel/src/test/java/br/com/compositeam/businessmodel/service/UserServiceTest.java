package br.com.compositeam.businessmodel.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.businessmodel.model.User;

public class UserServiceTest {

	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("spring.xml");
	}
	@Test
	public void testService() {
		User user = new User();
		user.setEmail("test4@email");
		user.setPassword("12345");
		UserService service = context.getBean(UserService.class);
		service.save(user);
		user = new User();
		user.setEmail("tes2t@email");
		user.setPassword("12345");
		service.save(user);
	}

}
