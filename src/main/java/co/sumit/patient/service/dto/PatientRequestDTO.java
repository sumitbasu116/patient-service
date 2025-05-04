package co.sumit.patient.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
	
	@NotBlank(message = "Name is required")
	@Size(max=100,message = "Name can not exceed 100 characters")
	private String name;
	@NotBlank(message = "Email is required")
	@Email(message = "Eamil should be valid")
	private String email;
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Date Of Birth is required")
	private String dateOfBirth;
	
	@NotBlank(message = "Date Of registration is required")
	private String registeredDate;
}
