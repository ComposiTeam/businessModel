package br.com.compositeam.businessmodel.dao;

import br.com.compositeam.gradplanner.model.Result;
import br.com.compositeam.gradplanner.model.TranscriptOfRecords;

import java.util.ArrayList;
import java.util.List;

public interface TranscriptOfRecordsDAO {
	
	public void save(ArrayList<Result> results);
    
    public List<TranscriptOfRecords> list();
    
}
