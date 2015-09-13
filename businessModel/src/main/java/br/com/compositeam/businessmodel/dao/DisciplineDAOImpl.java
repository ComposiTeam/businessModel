package br.com.compositeam.businessmodel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import br.com.compositeam.businessmodel.model.Discipline;

@Service
public class DisciplineDAOImpl implements DisciplineDAO{
	private SessionFactory sessionFactory;
	
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
    
	public void save(Discipline p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
	}

	public List<Discipline> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DisciplineDAO get(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DisciplineDAO personDAO = context.getBean(DisciplineDAO.class);
		return personDAO;
	}

}
