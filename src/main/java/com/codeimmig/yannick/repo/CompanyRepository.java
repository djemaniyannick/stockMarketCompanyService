package com.codeimmig.yannick.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeimmig.yannick.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
