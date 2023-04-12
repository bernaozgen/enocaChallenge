package com.berna.ozgen.demo.business.requests.creates;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {
	@NotBlank(message = "company name cannot be empty")
	private String companyName;

}
