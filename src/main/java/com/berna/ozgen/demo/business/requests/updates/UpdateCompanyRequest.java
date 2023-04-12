package com.berna.ozgen.demo.business.requests.updates;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {
	@NotNull
	private int companyId;

	@NotNull
	@NotEmpty
	private String companyName;
}
