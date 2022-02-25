package com.codeimmig.yannick.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeimmig.yannick.entity.Company;
import com.codeimmig.yannick.exception.CompanyNotFoundException;
import com.codeimmig.yannick.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;
 @Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {
	
	@Autowired
	private ICompanyService service;
	
	//1.create 
	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		ResponseEntity<String> response=null;
		try {
			Long id=service.createCompany(company);
			response=ResponseEntity.ok("CREATED WITH ID :"+id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	// fetch all company
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompany(){
		ResponseEntity<List<Company>> response=null;
		log.info("ENTERED INTO FECHT METHOD");
		
		try {
			List<Company> list=service.getAllCompagnies();
			response=new ResponseEntity<List<Company>>(list, HttpStatus.OK);
			log.info("FETCH METHOD IS SUCCESS");
			
		} catch (CompanyNotFoundException e) {
			e.printStackTrace();
			throw e;
					}
		log.info("ABOUT TO LEAVE FETCH ONE METHOD");
		return response;

	}
	
	//3. fetch one
		@GetMapping("/fetch/{id}")
		public ResponseEntity<Company> getOneCompany(
				@PathVariable Long id
				)
		{
			ResponseEntity<Company> response = null;
			log.info("ENTERED INTO FETCH ONE METHOD");
			try {
				Company cob = service.getOneCompany(id);
				response = new ResponseEntity<Company>(cob, HttpStatus.OK);
				log.info("FETCH ONE METHOD IS SUCCESS");
			} catch (CompanyNotFoundException e) {
				//e.printStackTrace();
				log.error(e.getMessage());
				throw e;
			}
			log.info("ABOUT TO LEAVE FETCH ONE METHOD");
			return response;
		}
}
