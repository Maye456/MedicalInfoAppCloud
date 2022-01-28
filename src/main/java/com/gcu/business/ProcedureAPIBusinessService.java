package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProcedureRepository;
import com.gcu.model.ProcedureEntity;
import com.gcu.model.ProcedureModel;

@Service
public class ProcedureAPIBusinessService 
{
	@Autowired
	private ProcedureRepository procedureRepository;
	
	public ProcedureAPIBusinessService(ProcedureRepository procedureRepository)
	{
		this.procedureRepository = procedureRepository;
	}
	
	public List<ProcedureModel> getAllProcedures()
	{
		// Get all the Entity Procedures
		List<ProcedureEntity> procedureEntity = (List<ProcedureEntity>) procedureRepository.findAll();
		
		List<ProcedureModel> procedureDomain = new ArrayList<ProcedureModel>();
		for (ProcedureEntity entity : procedureEntity)
		{
			procedureDomain.add(new ProcedureModel(entity.getId(), entity.getProcedureName(), entity.getRiskFactor(), entity.getSpecialtyArea(), entity.getDescription(), entity.getPrice(), entity.getPhoto()));
		}
		
		// Return List of Domain Procedures
		return procedureDomain;
	}

	public List<ProcedureModel> searchProcedures(String searchTerm)
	{
		// Get 1 Entity Procedure
		List<ProcedureEntity> procedureEntity = procedureRepository.findByProcedureNameContainingIgnoreCase(searchTerm);
		
		List<ProcedureModel> procedureDomain = new ArrayList<ProcedureModel>();
		for (ProcedureEntity entity : procedureEntity)
		{
			procedureDomain.add(new ProcedureModel(entity.getId(), entity.getProcedureName(), entity.getRiskFactor(), entity.getSpecialtyArea(), entity.getDescription(), entity.getPrice(), entity.getPhoto()));
		}
		
		// Return List of Domain Procedures
		return procedureDomain;
	}
}
