package br.com.compositeam.businessmodel.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.businessmodel.model.Person;
import br.com.compositeam.businessmodel.model.User;

public class PersonServiceTest {
	
	private ClassPathXmlApplicationContext context;
	private PersonService personService;
	private UserService userService;
	private String email = "impossiveldeterIgual@email.com";
	private String password = "teste";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring.xml");
		personService = context.getBean(PersonService.class);
		userService = context.getBean(UserService.class);
	}

	@After
	public void tearDown() throws Exception {
		context.close();
	}

	@Test
	public void testUser() {
		try{
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			userService.save(user);
			Person person = new Person(user, "Teste","Teste");
			personService.save(person);
			personService.delete(person);
			userService.delete(user);
			
		}catch(Exception ex){
			ex.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void test() {
		try{
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			Person p = new Person(email,password,"Teste","Teste");
			personService.save(p);
		}catch(Exception ex){
			ex.printStackTrace();
			fail();
		}
	}

}
