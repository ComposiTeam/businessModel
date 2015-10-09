package br.com.compositeam.businessmodel.service;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.compositeam.businessmodel.model.Role;

public class RoleServiceTest {

	private ClassPathXmlApplicationContext context;
	
	private RoleService service;
	@Before
	public void setUp(){
		context = new ClassPathXmlApplicationContext("spring.xml");
		service = context.getBean(RoleService.class);
	}
	
	@Test
	public void insert(){
		String description = "test.role";
		Role r = service.save(description);
		Assert.assertEquals(description, r.getDescription());
		service.delete(r);
	}
}
