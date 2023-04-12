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

import com.berna.ozgen.demo.business.abstracts.EmployeeService;
import com.berna.ozgen.demo.business.requests.creates.CreateEmployeeRequest;
import com.berna.ozgen.demo.business.requests.delete.DeleteEmployeeRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateEmployeeRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateEmployeeResponse;
import com.berna.ozgen.demo.business.responses.delete.DeleteEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetAllEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetByEmployeeResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateEmployeeResponse;
import com.kodlamaio.common.utilities.results.DataResult;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<?> add(@RequestBody @Valid CreateEmployeeRequest createEmployeeRequest) {
		DataResult<CreateEmployeeResponse> result = this.employeeService.add(createEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping()
	public ResponseEntity<?> update(@RequestBody @Valid UpdateEmployeeRequest updateEmployeeRequest) {
		DataResult<UpdateEmployeeResponse> result = this.employeeService.update(updateEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@DeleteMapping()
	public ResponseEntity<?> delete(@RequestBody @Valid DeleteEmployeeRequest deleteEmployeeRequest) {
		DataResult<DeleteEmployeeResponse> result = this.employeeService.delete(deleteEmployeeRequest);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping()
	public ResponseEntity<?> getAll() {
		DataResult<List<GetAllEmployeeResponse>> result = this.employeeService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<?> getByEmployee(@PathVariable @Valid int employeeId) {
		DataResult<GetByEmployeeResponse> result = this.employeeService.getByEmployee(employeeId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}

}
