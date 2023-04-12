package com.berna.ozgen.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.berna.ozgen.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee getById(int employeeId);

	Employee getByNationalityId(String nationalityId);
}
