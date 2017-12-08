package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class User {
	public Long id;
	public static long counter = (long) 01;
	public String firstName;
	public String lastName;
	public int age;
	public String occupation;
	public String gender;
	public String role;

	public Map<Long, Movie> movietitle = new HashMap<>();

	public User(String firstName, String lastName, int age, String occupation, String gender, String role) {
		this.id = counter++;
		;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.occupation = occupation;
		this.gender = gender;
		this.role = role;
	}

	public User(String firstName, String lastName, int age, String occupation, String gender) {
		this(firstName, lastName, age, occupation, gender, "default");
	}

	@Override
	public String toString() {
		return toStringHelper(this).addValue(id).addValue(firstName).addValue(lastName).addValue(age).addValue(occupation).addValue(gender)
				.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.lastName, this.firstName, this.age, this.occupation, this.gender);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof User) {
			final User other = (User) obj;
			return Objects.equal(firstName, other.firstName) && Objects.equal(lastName, other.lastName)
					&& Objects.equal(age, other.age) && Objects.equal(occupation, other.occupation)
					&& Objects.equal(gender, other.gender);
		} else {
			return false;
		}
	}
	
	
	//getters + setters for User
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getfirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getOccuptation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}