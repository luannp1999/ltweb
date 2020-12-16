package springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.exception.ResourceNotFoundException;
import springboot.model.Doctor;
import springboot.repository.DoctorRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class DoctorController {

	@Autowired
	private DoctorRepository doctorRepository;
	
	// get all doctor
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}		
	
	// create doctor rest api
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	
	// get doctor by id rest api
	@GetMapping("/doctors/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		return ResponseEntity.ok(doctor);
	}
	
	// update doctor rest api
	
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails){
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		doctor.setName(doctorDetails.getName());
		doctor.setCmt(doctorDetails.getCmt());
		doctor.setBirthday(doctorDetails.getBirthday());
		doctor.setAddress(doctorDetails.getAddress());
		doctor.setLevel(doctorDetails.getLevel());
		doctor.setExperience(doctorDetails.getExperience());
		doctor.setDegree(doctorDetails.getDegree());	
		Doctor updatedDoctor = doctorRepository.save(doctor);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	// delete doctor rest api
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDoctor(@PathVariable Long id){
		Doctor doctor = doctorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id :" + id));
		
		doctorRepository.delete(doctor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
