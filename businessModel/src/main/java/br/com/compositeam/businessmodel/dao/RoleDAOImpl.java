package br.com.compositeam.businessmodel.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.compositeam.businessmodel.model.Role;
import br.com.compositeam.businessmodel.model.User;

public class RoleDAOImpl implements RoleDAO {
	private final static Logger LOGGER = Logger.getLogger(RoleDAOImpl.class.getName());
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Role role) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(role);
		tx.commit();
		session.close();
	}

	public List<Role> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Role> roles = session.createCriteria(Role.class).list();
		session.close();
		return roles;
	}
	
	public Role getRole(String description){
		Session session = this.sessionFactory.openSession();
		Role role = (Role)session.createCriteria(Role.class).add(Restrictions.eq("role", description)).uniqueResult();
		if(role == null){
			LOGGER.info("There is not a result from query to find a user");
		}
		session.close();
		return role;
	}
	
	public void delete(Role role){
		LOGGER.info("The object role is going to be delete");
		Session session = this.sessionFactory.openSession();
		session.delete(role);
		session.close();
	}
	
	public Role save(String role){
		Role r = new Role();
		r.setDescription(role);
		this.save(r);
		return r;
	}

}
