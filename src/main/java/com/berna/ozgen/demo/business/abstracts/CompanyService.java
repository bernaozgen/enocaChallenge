package com.berna.ozgen.demo.business.abstracts;

import java.util.List;

import com.berna.ozgen.demo.business.requests.creates.CreateCompanyRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateCompanyRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetAllCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetByCompanyResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateCompanyResponse;
import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.Result;

public interface CompanyService {

	DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest);

	DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest);

	Result delete(int companyId);

	DataResult<List<GetAllCompanyResponse>> getAll();

	DataResult<GetByCompanyResponse> getByCompany(int companyId);
}
