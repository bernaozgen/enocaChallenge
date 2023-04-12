package com.berna.ozgen.demo.business.abstracts;

import java.util.List;

import com.berna.ozgen.demo.business.requests.creates.CreateEmployeeRequest;
import com.berna.ozgen.demo.business.requests.delete.DeleteEmployeeRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateEmployeeRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateEmployeeResponse;
import com.berna.ozgen.demo.business.responses.delete.DeleteEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetAllEmployeeResponse;
import com.berna.ozgen.demo.business.responses.get.employees.GetByEmployeeResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateEmployeeResponse;
import com.kodlamaio.common.utilities.results.DataResult;

public interface EmployeeService {

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);

	DataResult<DeleteEmployeeResponse> delete(DeleteEmployeeRequest deleteEmployeeRequest);

	DataResult<List<GetAllEmployeeResponse>> getAll();

	DataResult<GetByEmployeeResponse> getByEmployee(int employeeId);
}
