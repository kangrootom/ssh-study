package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}
	@Override
	public Employee getEmpByNo(Integer empNo) {
		// TODO Auto-generated method stub
		return employeeDao.getEmpByNo(empNo);
	}
	@Override
	public void saveOrUpdate(Employee model) {
		// TODO Auto-generated method stub
		employeeDao.saveOrUpdate(model);
	}
	@Override
	public boolean isLastNameValid(String lastName) {
		// TODO Auto-generated method stub
		return employeeDao.isLastNameValid(lastName)==null;
	}
	@Override
	public void delete(Integer empNo) {
		// TODO Auto-generated method stub
		employeeDao.delete(empNo);
	}

}
