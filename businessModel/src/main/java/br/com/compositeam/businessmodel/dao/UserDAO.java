package br.com.compositeam.businessmodel.dao;

import java.util.List;

import br.com.compositeam.businessmodel.model.User;

public interface UserDAO {
	
	public void save(User user);
    
    public List<User> list();
    
    public boolean login(User user);
    
    public User getUser(String email);
    
    public void delete(User user);
}
