package com.berna.ozgen.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berna.ozgen.demo.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	Company findById(int companyId);

	Company getByCompanyName(String companyName);

}
