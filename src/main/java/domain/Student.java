package domain;

import java.sql.Date;

public class Student {

	private int id;
	private String name;
	private String surname;
	private Date enrolmentDate;
	private int groupId;
	private int markId;
	private int number;
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setNumber(int number) {

		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEnrolmentDate(Date enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Date getEnrolmentDate() {
		return enrolmentDate;
	}

	public int getGroupId() {
		return groupId;
	}

	public int getMarkId() {
		return markId;
	}

	@Override
	public String toString() {
		return "( id " + this.id + ", name " + this.name + ", surname " + this.surname + ", enrolmentDate "
				+ this.enrolmentDate + ", groupId " + this.groupId + " number " + this.number + " depatment "
				+ this.department + ", markId " + this.markId + " )";
	}

}
