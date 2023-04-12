package com.berna.ozgen.demo.business.responses.creates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyResponse {
	private int companyId;
	private String companyName;
}
