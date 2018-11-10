package com.atguigu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private Session session;
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		String hql = "from Employee e LEFT OUTER JOIN FETCH e.dept";
		return getSession().createQuery(hql).list();
	}

	@Override
	public Employee getEmpByNo(Integer empNo) {
		// TODO Auto-generated method stub
		String hql = "from Employee e WHERE e.empNo = ?";
		return (Employee) getSession().createQuery(hql).setInteger(0, empNo).uniqueResult();
	}

	@Override
	public void saveOrUpdate(Employee model) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(model);
	}

	@Override
	public Object isLastNameValid(String lastName) {
		// TODO Auto-generated method stub
		String hql = "FROM Employee e where e.lastName = ?";
		
		return getSession().createQuery(hql).setString(0, lastName).uniqueResult();
	}

	@Override
	public void delete(Integer empNo) {
		// TODO Auto-generated method stub
		String hql = "DELETE FROM Employee e where e.empNo = :empNo";
		Query query = getSession().createQuery(hql).setParameter("empNo", empNo);
		query.executeUpdate();
		
	}
	
	
	

}
