package com.gcu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProcedureAPIBusinessService;
import com.gcu.model.ProcedureModel;

@RestController
@RequestMapping("/api")
public class ProcedureRestService 
{
	@Autowired
	ProcedureAPIBusinessService service;
	
	@GetMapping("/procedures")
	public ResponseEntity<?> getProcedures()
	{
		try
		{
			List<ProcedureModel> procedures = service.getAllProcedures();
			if (procedures == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(procedures, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/procedures/{searchTerm}")
	public ResponseEntity<?> searchProcedures(@PathVariable(name="searchTerm") String searchTerm)
	{
		List<ProcedureModel> procedures = null;
		try
		{
			procedures = service.searchProcedures(searchTerm);
			if (procedures == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<>(procedures, HttpStatus.OK);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
