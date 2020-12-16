package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientID;

	@Column(name = "CMT")
	private int cmt;
	
	@Column(name = "name")
	private String name;
	

	@Column(name = "DOB")
	private String birthday;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;

	public Patient() {
		
	}

	public Patient(int cmt, String name, String birthday, String address, String phone) {
		super();
		this.cmt = cmt;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
	}

	public long getPatientID() {
		return patientID;
	}

	public void setPatientID(long patientID) {
		this.patientID = patientID;
	}

	public int getCmt() {
		return cmt;
	}

	public void setCmt(int cmt) {
		this.cmt = cmt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
