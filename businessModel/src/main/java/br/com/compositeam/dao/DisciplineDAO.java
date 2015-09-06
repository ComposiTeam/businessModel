package br.com.compositeam.dao;

import java.util.List;

import br.com.compositeam.model.Discipline;

public interface DisciplineDAO {

	public void save(Discipline p);
    
    public List<Discipline> list();
}
