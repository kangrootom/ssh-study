package com.atguigu.service;

import java.util.List;

import com.atguigu.pojo.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee getEmpByNo(Integer empNo);

	public void saveOrUpdate(Employee model);

	public boolean isLastNameValid(String lastName);

	public void delete(Integer empNo);
}
