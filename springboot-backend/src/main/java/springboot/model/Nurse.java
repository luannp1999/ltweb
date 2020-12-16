package springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nurse")
public class Nurse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nurseID;
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
	@Column(name = "major")
	private String major;
	public Nurse() {
		
	}
	public Nurse(int cmt, String name, String birthday, String address, String level, String experience,
			String degree, String major) {
		super();
		this.cmt = cmt;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.level = level;
		this.experience = experience;
		this.degree = degree;
		this.major = major;
	}
	public long getNurseID() {
		return nurseID;
	}
	public void setNurseID(long nurseID) {
		this.nurseID = nurseID;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}