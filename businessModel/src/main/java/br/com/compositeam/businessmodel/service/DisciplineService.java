package br.com.compositeam.businessmodel.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import br.com.compositeam.businessmodel.dao.DisciplineDAO;
import br.com.compositeam.businessmodel.model.Discipline;

@Service
public class DisciplineService {

	private DisciplineDAO disciplineDAO;
	
	public void setDisciplineDao(DisciplineDAO disciplineDAO){
		this.disciplineDAO = disciplineDAO;
	}
	
	public DisciplineService(){
		
	}
	
	public void save(Discipline discipline){
		disciplineDAO.save(discipline);
	}
	
	public List<Discipline> getAll(){
		return disciplineDAO.list();
	}
	
	public static DisciplineService get(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DisciplineService personDAO = context.getBean(DisciplineService.class);
		return personDAO;
	}
}
