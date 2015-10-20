package br.com.compositeam.businessmodel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.compositeam.businessmodel.model.Discipline;
import br.com.compositeam.businessmodel.model.Person;

public class PersonDAOImpl implements PersonDAO {
	
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Person person) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(person);
        tx.commit();
        session.close();
		
	}

	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> persons = session.createCriteria(Person.class).list();
		session.close();
		return persons;
	}

	public void delete(Person person) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(person);
        tx.commit();
        session.close();
		
	}

	public void update(Person person) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        session.close();
		
	}

}
