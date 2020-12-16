package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

}
