package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee getEmpByNo(Integer empNo);

	public void saveOrUpdate(Employee model);

	public Object isLastNameValid(String lastName);

	public void delete(Integer empNo);
		
	
}
