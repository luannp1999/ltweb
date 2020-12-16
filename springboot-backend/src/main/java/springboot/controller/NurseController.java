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
import springboot.model.Nurse;
import springboot.repository.NurseRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NurseController {

	@Autowired
	private NurseRepository nurseRepository;
	
	// get all nurses
	@GetMapping("/nurses")
	public List<Nurse> getAllNurses(){
		return nurseRepository.findAll();
	}		
	
	// create nurse rest api
	@PostMapping("/nurses")
	public Nurse createNurse(@RequestBody Nurse nurse) {
		return nurseRepository.save(nurse);
	}
	
	// get nurse by id rest api
	@GetMapping("/nurses/{id}")
	public ResponseEntity<Nurse> getNurseById(@PathVariable Long id) {
		Nurse nurse = nurseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nurse not exist with id :" + id));
		return ResponseEntity.ok(nurse);
	}
	
	// update doctor rest api
	
	@PutMapping("/nurses/{id}")
	public ResponseEntity<Nurse> updateNurse(@PathVariable Long id, @RequestBody Nurse nurseDetails){
		Nurse nurse = nurseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nurse not exist with id :" + id));
		

		nurse.setCmt(nurseDetails.getCmt());
		nurse.setName(nurseDetails.getName());
		nurse.setBirthday(nurseDetails.getBirthday());
		nurse.setAddress(nurseDetails.getAddress());
		nurse.setLevel(nurseDetails.getLevel());
		nurse.setExperience(nurseDetails.getExperience());
		nurse.setDegree(nurseDetails.getDegree());
		nurse.setMajor(nurseDetails.getMajor());
		
		Nurse updatedNurse = nurseRepository.save(nurse);
		return ResponseEntity.ok(updatedNurse);
	}
	
	// delete doctor rest api
	@DeleteMapping("/nurses/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNurse(@PathVariable Long id){
		Nurse nurse = nurseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("nurse not exist with id :" + id));
		
		nurseRepository.delete(nurse);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
