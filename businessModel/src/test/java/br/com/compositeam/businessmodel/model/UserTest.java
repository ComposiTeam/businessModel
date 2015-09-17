package br.com.compositeam.businessmodel.model;

import junit.framework.Assert;

import org.junit.Test;

public class UserTest {

	@Test
	public void testGettersAndSetters() {
		User user = new User();
		user.setEmail("test@email.com");
		Assert.assertEquals(user.getEmail(),"test@email");
		user.setPassword("12345");
		Assert.assertEquals(user.getPassword(),"12345");
	}

}
