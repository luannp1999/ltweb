package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.model.Nurse;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long>{

}
