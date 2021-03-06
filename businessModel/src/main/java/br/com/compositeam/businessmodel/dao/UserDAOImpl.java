package br.com.compositeam.businessmodel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.compositeam.businessmodel.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		user.setPassword(user.getEncryPassword());
		session.persist(user);
		tx.commit();
		session.close();
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}

	public boolean login(User user) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		boolean exists = session.createCriteria(User.class).equals(user);
		return exists;
	}
}
