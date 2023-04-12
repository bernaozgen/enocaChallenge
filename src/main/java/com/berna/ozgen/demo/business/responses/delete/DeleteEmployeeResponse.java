package com.berna.ozgen.demo.business.responses.delete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeResponse {
	private int employeeId;
	private String nationalityId;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private int companyId;

}
