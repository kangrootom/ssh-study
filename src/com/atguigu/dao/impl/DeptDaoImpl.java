package com.atguigu.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atguigu.dao.DeptDao;
import com.atguigu.pojo.Dept;

public class DeptDaoImpl implements DeptDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session session;
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		String hql = "FROM Dept";
		return getSession().createQuery(hql).list();
	}

}
