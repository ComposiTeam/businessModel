package br.com.compositeam.businessmodel.service;

import java.util.ArrayList;
import java.util.List;

import br.com.compositeam.businessmodel.dao.TranscriptOfRecordsDAO;
import br.com.compositeam.gradplanner.model.Result;
import br.com.compositeam.gradplanner.model.TranscriptOfRecords;


public class TranscriptOfRecordsService {
	
	private TranscriptOfRecordsDAO transcriptOfRecordsDAO;
	
	public TranscriptOfRecordsService(){
		
	}
	
	public void setTranscriptOfRecordsDAO(TranscriptOfRecordsDAO transcriptOfRecordsDAO){
		this.transcriptOfRecordsDAO = transcriptOfRecordsDAO;
	}
	
	public void save(ArrayList<Result> results){
		transcriptOfRecordsDAO.save(results);
	}
	
	public List<TranscriptOfRecords> getAll(){
		return transcriptOfRecordsDAO.list();
	}

}
