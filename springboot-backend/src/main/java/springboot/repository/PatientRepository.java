package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
