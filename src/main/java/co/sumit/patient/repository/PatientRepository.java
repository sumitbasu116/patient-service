package co.sumit.patient.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.sumit.patient.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
	boolean existsByEmail(String email);
}
