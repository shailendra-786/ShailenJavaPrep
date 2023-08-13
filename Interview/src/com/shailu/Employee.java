package com.shailu;

public class Employee {
	private int id;
	private String EmpName;
	private String DepartMent;

	public Employee(int id, String empName, String departMent) {
		this.id = id;
		EmpName = empName;
		DepartMent = departMent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getDepartMent() {
		return DepartMent;
	}

	public void setDepartMent(String departMent) {
		DepartMent = departMent;
	}

}
