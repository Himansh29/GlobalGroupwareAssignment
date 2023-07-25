package com.example.entity;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "rest")
public class Employee {

	@Id
	@Field
	private Long id;
	@Field
	private String employeeName;
	@Field
	private String phoneNumber;
	@Field
	private String email;
	@Field
	private UUID reportsTo;
	@Field
	private String profileImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UUID getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(UUID reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Employee(Long id, String employeeName, String phoneNumber, String email, UUID reportsTo,
			String profileImage) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.reportsTo = reportsTo;
		this.profileImage = profileImage;
	}

	public Employee(String employeeName, String phoneNumber, String email, UUID reportsTo, String profileImage) {
		super();
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.reportsTo = reportsTo;
		this.profileImage = profileImage;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", reportsTo=" + reportsTo + ", profileImage=" + profileImage + "]";
	}

}
