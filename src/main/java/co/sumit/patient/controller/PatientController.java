package co.sumit.patient.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sumit.patient.service.PatientService;
import co.sumit.patient.service.dto.PatientResponseDTO;

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
}
