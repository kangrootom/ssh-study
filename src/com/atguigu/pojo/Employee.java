package com.atguigu.pojo;

import java.util.Date;

public class Employee {
	private Integer empNo;
	private String lastName;
	private String email;
	private Date birth;
	private Date hiredate;
	private Dept dept;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", lastName=" + lastName + ", email=" + email + ", birth=" + birth
				+ ", hiredate=" + hiredate + "]";
	}
	
	
	

}
