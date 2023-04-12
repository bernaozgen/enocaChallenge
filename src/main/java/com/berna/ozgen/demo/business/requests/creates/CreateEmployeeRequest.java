package com.berna.ozgen.demo.business.requests.creates;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
	@NotBlank(message = "nationality Id cannot be empty")
	@Size(min = 11, max = 11)
	private String nationalityId;

	@NotBlank(message = "first name cannot be empty")
	private String firstName;

	@NotBlank(message = "last name cannot be empty")
	private String lastName;

	@NotBlank(message = "phone cannot be empty")
	@Pattern(regexp = "\\d{11}", message = "Invalid phone number")
	private String phone;

	@NotBlank(message = "email cannot be empty")
	@Email(message = "wrong email")
	private String email;

	@NotNull(message = "company Id cannot be empty")
	private int companyId;
}
