package br.com.compositeam.businessmodel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.compositeam.gradplanner.model.TranscriptOfRecords;

public class TranscriptOfRecordsImpl implements TranscriptOfRecordsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(TranscriptOfRecords transcriptOfRecords) {		
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(transcriptOfRecords);
        tx.commit();
        session.close();		
	}

	public List<TranscriptOfRecords> list() {
		
		Session session = this.sessionFactory.openSession();
		/*
		 * Hibernate will create a Criteria object that returns instances of 
		 * classes of persistent objects when the application runs a query to the API
		 */
		List<TranscriptOfRecords> transcripts = session.createCriteria(TranscriptOfRecords.class).list();
		session.close();
		return transcripts;
		
	}

	
}
