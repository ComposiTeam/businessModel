package br.com.compositeam.businessmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import br.com.compositeam.businessmodel.dao.UserDAO;
import br.com.compositeam.businessmodel.model.User;

@Service
public class UserService {

	private UserDAO userDAO;
	
	public UserService(){
		
	}
	
	public void setUserDAO(UserDAO userDAO){
		this.userDAO = userDAO;
	}
	
	public void save(User user){
		userDAO.save(user);
	}
	
	public List<User> getAll(){
		return userDAO.list();
	}
	
	public boolean login(User user){
		return userDAO.login(user);
	}
	
	public User getUser(String email){
		return userDAO.getUser(email);
	}
	
	public void delete(User user){
		userDAO.delete(user);
	}
	
	
}
