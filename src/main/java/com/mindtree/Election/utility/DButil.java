package com.mindtree.Election.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.mindtree.Election.exceptions.ElectionDaoException;

public class DButil {

	public static Session getSession() throws ElectionDaoException {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {
			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			return session;
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			throw new ElectionDaoException("Cannot create connection", ex.getCause());
		}

	}

}
