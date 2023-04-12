package com.berna.ozgen.demo.webApi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berna.ozgen.demo.business.abstracts.CompanyService;
import com.berna.ozgen.demo.business.requests.creates.CreateCompanyRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateCompanyRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetAllCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetByCompanyResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateCompanyResponse;
import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompaniesController {

	private CompanyService companyService;

	@PostMapping()
	public ResponseEntity<?> add(@RequestBody @Valid CreateCompanyRequest createCompanyRequest) {
		DataResult<CreateCompanyResponse> result = this.companyService.add(createCompanyRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping()
	public ResponseEntity<?> update(@RequestBody @Valid UpdateCompanyRequest updateCompanyRequest) {
		DataResult<UpdateCompanyResponse> result = this.companyService.update(updateCompanyRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping("/{companyId}")
	public ResponseEntity<?> delete(@PathVariable int companyId) {
		Result result = this.companyService.delete(companyId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);

	}

	@GetMapping()
	public ResponseEntity<?> getAll() {

		DataResult<List<GetAllCompanyResponse>> result = this.companyService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/{companyId}")
	public ResponseEntity<?> getByCompany(@PathVariable int companyId) {
		DataResult<GetByCompanyResponse> result = this.companyService.getByCompany(companyId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
