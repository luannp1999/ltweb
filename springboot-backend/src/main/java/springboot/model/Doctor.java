package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorID;

	@Column(name = "CMT")
	private int cmt;
	
	@Column(name = "name")
	private String name;
	

	@Column(name = "DOB")
	private String birthday;
	@Column(name = "address")
	private String address;
	@Column(name = "level")
	private String level;
	@Column(name = "experience")
	private String experience;
	@Column(name = "degree")
	private String degree;

	public Doctor() {
		
	}

	public Doctor(int cmt, String name, String birthday, String address, String level, String experience,
			String degree) {
		super();
		this.cmt = cmt;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.level = level;
		this.experience = experience;
		this.degree = degree;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
	
}
