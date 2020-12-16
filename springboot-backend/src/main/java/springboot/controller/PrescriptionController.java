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
import springboot.model.Prescription;
import springboot.repository.PrescriptionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PrescriptionController {

	@Autowired
	private  PrescriptionRepository prescriptionRepository;
	
	// get all doctor
	@GetMapping("/prescriptions")
	public List<Prescription> getAllPrescription(){
		return prescriptionRepository.findAll();
	}		
	
	// create doctor rest api
	@PostMapping("/prescriptions")
	public Prescription createPrescription(@RequestBody Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}
	
	// get doctor by id rest api
	@GetMapping("/prescriptions/{id}")
	public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
		Prescription prescription = prescriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("prescription not exist with id :" + id));
		return ResponseEntity.ok(prescription);
	}
	
	// update doctor rest api
	
	@PutMapping("/prescriptions/{id}")
	public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescriptionDetails){
		Prescription prescription = prescriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("prescription not exist with id :" + id));
		
		prescription.setName(prescriptionDetails.getName());
		prescription.setPrice(prescriptionDetails.getPrice());
			
		Prescription updatedPrescription = prescriptionRepository.save(prescription);
		return ResponseEntity.ok(updatedPrescription);
	}
	
	// delete doctor rest api
	@DeleteMapping("/prescriptions/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePrescription(@PathVariable Long id){
		Prescription prescription = prescriptionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("prescription not exist with id :" + id));
		
		prescriptionRepository.delete(prescription);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
