package co.sumit.patient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sumit.patient.exception.EmailAlreadyExistsException;
import co.sumit.patient.model.Patient;
import co.sumit.patient.repository.PatientRepository;
import co.sumit.patient.service.dto.PatientRequestDTO;
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
	
	public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
		if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
			throw new EmailAlreadyExistsException("A Patient with this email is already exists "+
					patientRequestDTO.getEmail());
		}
		Patient newPatient = patientRepository.save(PatientMapper.toEntityModel(patientRequestDTO));
		return PatientMapper.toDTO(newPatient);
	}
}
