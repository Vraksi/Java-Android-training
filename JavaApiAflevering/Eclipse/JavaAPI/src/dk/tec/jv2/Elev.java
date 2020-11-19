package dk.tec.jv2;

import java.util.ArrayList;

public class Elev 
{
	int id;
	String name;
	int age;
	
	int year;
	boolean driverslicense;
	int gender;
	int relationshipStatus;
	
	ArrayList<String> skills;
	
	public Elev (int id, String name, int age, String skill) 
	{
		this.id = id;
		this.name = name;
		this.age = age;
		skills = new ArrayList<String>();
		skills.add(skill);
	}

	public void addSkill(String skill) {
		skills.add(skill);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
}
