package com.berna.ozgen.demo.business.requests.delete;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeRequest {
	@NotNull(message = "employee Id cannot be empty")
	private int employeeId;
}
