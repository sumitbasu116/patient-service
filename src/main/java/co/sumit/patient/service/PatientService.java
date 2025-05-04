package co.sumit.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sumit.patient.model.Patient;
import co.sumit.patient.repository.PatientRepository;
import co.sumit.patient.service.dto.PatientResponseDTO;
import co.sumit.patient.service.mapper.PatientMapper;

@Service
public class PatientService {

	private PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository=patientRepository;
	}
	
	public List<PatientResponseDTO> getPatient(){
		List<Patient> patients = patientRepository.findAll();
		
		List<PatientResponseDTO> resultList = patients.stream().map(patient->PatientMapper.toDTO(patient)).toList();
		
		return resultList;
	}
}
