package com.berna.ozgen.demo.business.responses.updates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyResponse {

	private int companyId;
	private String companyName;
}
