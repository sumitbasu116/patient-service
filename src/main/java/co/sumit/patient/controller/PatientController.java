package co.sumit.patient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sumit.patient.service.PatientService;
import co.sumit.patient.service.dto.PatientRequestDTO;
import co.sumit.patient.service.dto.PatientResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

	private final PatientService patientService;
	
	public PatientController(PatientService patientService) {
		this.patientService=patientService;
	}
	
	@GetMapping
	public ResponseEntity<List<PatientResponseDTO>> getPatients(){
		 List<PatientResponseDTO> patients = patientService.getPatient();
		 return ResponseEntity.ok(patients);
	}
	
	@PostMapping
	public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO){
		PatientResponseDTO patient = patientService.createPatient(patientRequestDTO);
		return ResponseEntity.ok(patient);
	}
}
