package br.com.compositeam.businessmodel.dao;

import java.util.List;

import br.com.compositeam.businessmodel.model.User;

public interface UserDAO {
	
	public void save(User user);
    
    public List<User> list();
}
