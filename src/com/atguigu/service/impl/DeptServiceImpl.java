package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.dao.DeptDao;
import com.atguigu.pojo.Dept;
import com.atguigu.service.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

	

}
