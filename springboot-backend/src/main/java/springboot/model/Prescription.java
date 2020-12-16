package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Prescription")
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PrescriptionID;

	
	@Column(name = "name")
	private String name;
	

	@Column(name = "price")
	private float price;
	public Prescription() {
		
	}

	public Prescription(long prescriptionID, String name, float price) {
		super();
		PrescriptionID = prescriptionID;
		this.name = name;
		this.price = price;
	}

	public long getPrescriptionID() {
		return PrescriptionID;
	}

	public void setPrescriptionID(long prescriptionID) {
		PrescriptionID = prescriptionID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
