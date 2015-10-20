package br.com.compositeam.businessmodel.dao;

import java.util.List;
import java.util.logging.Logger;

import javassist.tools.reflect.Loader;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.compositeam.businessmodel.model.Role;
import br.com.compositeam.businessmodel.model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDAOImpl implements UserDAO {

	private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());
	private SessionFactory sessionFactory;
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO){
		this.roleDAO = roleDAO;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		user.setPassword(user.getEncryPassword());
		Role role = null;
		if(user.getRoles().size() == 0){
			role = (Role)session.createCriteria(Role.class).add(Restrictions.eq("description", "NORMAL_USER")).uniqueResult();
			
		}
		role.addUser(user);
		user.addRole(role);
//		roleDAO.update(role);
//		user.addRole("NORMAL_USER");
		session.persist(user);
		tx.commit();
		session.close();
		LOGGER.info("User id " + user.getId());
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}
	
	public User getUser(String email){
		Session session = this.sessionFactory.openSession();
		User user = (User)session.createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
		if(user == null){
			LOGGER.info("There is not a result from query to find a user");
		}
		session.close();
		return user;
	}

	public boolean login(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		boolean exists = session.createCriteria(User.class).equals(user);
		return exists;
	}

	public void delete(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
		
	}
}
