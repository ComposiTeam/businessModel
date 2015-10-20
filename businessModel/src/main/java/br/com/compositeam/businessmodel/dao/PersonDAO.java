package br.com.compositeam.businessmodel.dao;

import java.util.List;

import br.com.compositeam.businessmodel.model.Person;
import br.com.compositeam.businessmodel.model.Role;

public interface PersonDAO {
	public void save(Person person);
    
    public List<Person> list();
    
    public void delete(Person person);
    
    public void update(Person person);
}
