package br.com.compositeam.businessmodel.dao;

import java.util.List;

import br.com.compositeam.businessmodel.model.Discipline;

public interface DisciplineDAO {

	public void save(Discipline p);
    
    public List<Discipline> list();
}
