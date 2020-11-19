package dk.tec.jv2;

public class Person {
	public int id;
	public String name;
	public String job;
	public int yearOfBirth;
	public Boolean driversLicense;
	public String gender;
	public String RelationshipStatus;
	
	public Person() {}
	
	public Person(int id, String name, String job, int yearOfBirth, Boolean driversLicense, String gender,
			String relationshipStatus) {
		super();
		this.id = id;
		this.name = name;
		this.job = job;
		this.yearOfBirth = yearOfBirth;
		this.driversLicense = driversLicense;
		this.gender = gender;
		this.RelationshipStatus = relationshipStatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public Boolean getDriversLicense() {
		return driversLicense;
	}
	public void setDriversLicense(Boolean driversLicense) {
		this.driversLicense = driversLicense;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelationshipStatus() {
		return RelationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.RelationshipStatus = relationshipStatus;
	}
	
	
}
