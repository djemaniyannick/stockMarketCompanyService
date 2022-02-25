package com.codeimmig.yannick.service;

import java.util.List;

import com.codeimmig.yannick.entity.Company;

public interface ICompanyService {
	Long createCompany(Company comp);
	void updateCompany(Company comp);
	Company getOneCompany(Long id);
	List<Company> getAllCompagnies();

}
