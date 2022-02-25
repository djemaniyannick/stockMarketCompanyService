package com.codeimmig.yannick.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeimmig.yannick.entity.Company;
import com.codeimmig.yannick.exception.CompanyNotFoundException;
import com.codeimmig.yannick.repo.CompanyRepository;
import com.codeimmig.yannick.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService{
	@Autowired
	CompanyRepository repo;

	@Override
	public Long createCompany(Company comp) {
		
		return repo.save(comp).getId();
	}

	@Override
	public void updateCompany(Company comp) {
		if(comp.getCregId()!=null && repo.existsById(comp.getId())) {
			repo.save(comp);
		}
		
	}

	@Override
	public Company getOneCompany(Long id) {
		return repo.findById(id).orElseThrow(()->new CompanyNotFoundException(" company '"+id+"' doesn't exist "));
	}

	@Override
	public List<Company> getAllCompagnies() {	
		return repo.findAll();
	}

}
