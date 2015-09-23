package br.com.compositeam.businessmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compositeam.businessmodel.dao.UserDAO;
import br.com.compositeam.businessmodel.model.User;

@Service
public class UserService {

	@Autowired
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
}
