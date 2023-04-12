package com.berna.ozgen.demo.business.responses.get.companies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCompanyResponse {

	private int companyId;
	private String companyName;
}
