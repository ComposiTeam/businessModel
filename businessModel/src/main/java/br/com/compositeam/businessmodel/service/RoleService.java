package br.com.compositeam.businessmodel.service;

import java.util.List;

import br.com.compositeam.businessmodel.dao.RoleDAO;
import br.com.compositeam.businessmodel.dao.UserDAO;
import br.com.compositeam.businessmodel.model.Role;
import br.com.compositeam.businessmodel.model.User;

public class RoleService {

	private RoleDAO roleDAO;
	
	public RoleService(){
		
	}
	
	public void setRoleDAO(RoleDAO roleDAO){
		this.roleDAO = roleDAO;
	}
	
	public void save(Role role){
		roleDAO.save(role);
	}
	
	public List<Role> getAll(){
		return roleDAO.list();
	}
	
	
	
	public Role getRole(String role){
		return roleDAO.getRole(role);
	}
	
	public Role save(String role){
		return roleDAO.save(role);
	}
	
	public void delete (Role role){
		roleDAO.delete(role);
	}
}
