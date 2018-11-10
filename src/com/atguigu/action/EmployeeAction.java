package com.atguigu.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.pojo.Dept;
import com.atguigu.pojo.Employee;
import com.atguigu.service.DeptService;
import com.atguigu.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8139434407510226727L;
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	public String list() throws Exception {
		// TODO Auto-generated method stub
		List<Employee> emps = employeeService.findAll();
		requestMap.put("emps", emps);
		return "list";
	}

	public String input() throws Exception {
		List<Dept> depts = deptService.findAll();
		requestMap.put("depts", depts);
		return "input";
	}
	public void prepareInput(){
		if(empNo != null){
			model = employeeService.getEmpByNo(empNo);
		}
	}
	public String save(){
		if(empNo == null){
			model.setHiredate(new Date());
		}
		employeeService.saveOrUpdate(model);
		return SUCCESS;
	}
	public void prepareSave(){

		if(empNo==null){
			model = new Employee();
		}else{
			model = employeeService.getEmpByNo(empNo);
		}
	}
	public String validateLastName() throws Exception{
		if(employeeService.isLastNameValid(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "ajax-result";
	}
	public String delete(){
		try {
			employeeService.delete(empNo);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return "ajax-result";
	}
	private Map<String, Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		this.requestMap=requestMap;
	}
	private Employee model;
	

	@Override
	public Employee getModel() {

		return model;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}
	private Integer empNo;
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	private String lastName;
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

}
