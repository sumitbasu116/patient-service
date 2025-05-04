package co.sumit.patient.service.mapper;

import java.time.LocalDate;

import co.sumit.patient.model.Patient;
import co.sumit.patient.service.dto.PatientRequestDTO;
import co.sumit.patient.service.dto.PatientResponseDTO;

public class PatientMapper {

	public static PatientResponseDTO toDTO(Patient patient) {
		PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
		patientResponseDTO.setId(patient.getId().toString());
		patientResponseDTO.setName(patient.getName());
		patientResponseDTO.setEmail(patient.getEmail());
		patientResponseDTO.setAddress(patient.getAddress());
		patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
		
		return patientResponseDTO;
	}
	
	public static Patient toEntityModel(PatientRequestDTO patientRequestDTO) {
		Patient patient = new Patient();
		patient.setName(patientRequestDTO.getName());
		patient.setAddress(patientRequestDTO.getAddress());
		patient.setEmail(patientRequestDTO.getEmail());
		patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
		patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
		return patient;
	}
	
}
