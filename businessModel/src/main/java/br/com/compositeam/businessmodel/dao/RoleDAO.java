package br.com.compositeam.businessmodel.dao;

import java.util.List;

import br.com.compositeam.businessmodel.model.Role;
import br.com.compositeam.businessmodel.model.User;

public interface RoleDAO {
	public void save(Role role);
    
    public List<Role> list();
    
    public Role save(String role);
    
    public void delete(Role role);
    
    
    public Role getRole(String role);
    
    public void update(Role role);
}
