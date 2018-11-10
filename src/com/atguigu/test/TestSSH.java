package com.atguigu.test;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSSH {

	private ClassPathXmlApplicationContext ctx;
	private SessionFactory sessionFactory;
	private Session session;
	
	{
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
	@Test
	public void testDataSource() {
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource);
		
	}
	@Test
	public void testSession() {
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.openSession();
		System.out.println(session);
		session.close();
	}

}
