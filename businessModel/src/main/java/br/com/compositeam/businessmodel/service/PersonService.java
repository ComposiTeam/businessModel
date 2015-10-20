package br.com.compositeam.businessmodel.service;

import java.util.List;


import br.com.compositeam.businessmodel.dao.PersonDAO;
import br.com.compositeam.businessmodel.model.Person;

public class PersonService {

	private PersonDAO personDAO;
	
	public void setPersonDAO(PersonDAO personDAO){
		this.personDAO = personDAO;
	}
	
	public void save(Person person) {
		this.personDAO.save(person);
		
	}

	public List<Person> list() {
		return this.personDAO.list();
	}

	public void delete(Person person) {
		this.personDAO.delete(person);
		
	}

	public void update(Person person) {
		this.personDAO.update(person);
		
	}
}
