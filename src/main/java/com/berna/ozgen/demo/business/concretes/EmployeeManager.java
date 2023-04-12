package com.berna.ozgen.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.berna.ozgen.demo.business.abstracts.EmployeeService;
import com.berna.ozgen.demo.business.constants.Messages;
import com.berna.ozgen.demo.business.requests.creates.CreateEmployeeRequest;
import com.berna.ozgen.demo.business.requests.delete.DeleteEmployeeRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateEmployeeRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateEmployeeResponse;
import com.berna.ozgen.demo.business.responses.delete.DeleteEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetAllEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetByEmployeeResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateEmployeeResponse;
import com.berna.ozgen.demo.dataAccess.abstracts.EmployeeRepository;
import com.berna.ozgen.demo.entities.Employee;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.SuccessDataResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {

		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeId(updateEmployeeRequest.getEmployeeId());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);

		return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse, Messages.EmployeeUpdated);
	}

	@Override
	public DataResult<DeleteEmployeeResponse> delete(DeleteEmployeeRequest deleteEmployeeRequest) {
		checkIfEmployeeId(deleteEmployeeRequest.getEmployeeId());
		Employee employee = this.employeeRepository.findById(deleteEmployeeRequest.getEmployeeId()).get();

		DeleteEmployeeResponse deleteEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				DeleteEmployeeResponse.class);
		this.employeeRepository.deleteById(employee.getEmployeeId());
		return new SuccessDataResult<DeleteEmployeeResponse>(deleteEmployeeResponse, Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(getAllEmployeeResponses, Messages.EmployeeListed);
	}

	@Override
	public DataResult<GetByEmployeeResponse> getByEmployee(int employeeId) {
		Employee employee = this.employeeRepository.getById(employeeId);
		GetByEmployeeResponse response = this.modelMapperService.forResponse().map(employee,
				GetByEmployeeResponse.class);
		return new SuccessDataResult<GetByEmployeeResponse>(response, Messages.EmployeeListed);
	}

	private void checkIfEmployeeId(int employeeId) { // id kontrolü yaptırıyor
		Employee employee = this.employeeRepository.findById(employeeId).get();
		if (employee == null) {
			throw new BusinessException(Messages.EmployeeExists);
		}
	}

}
