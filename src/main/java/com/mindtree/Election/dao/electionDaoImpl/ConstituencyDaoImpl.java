package com.mindtree.Election.dao.electionDaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.mindtree.Election.dao.ConstituencyDao;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;
import com.mindtree.Election.utility.DButil;

public class ConstituencyDaoImpl implements ConstituencyDao{

	@Override
	public void addConstituency(Constituency constituency) throws ElectionDaoException {
		
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.save(constituency);
			session.getTransaction().commit();
		}catch(HibernateException e){
			throw new ElectionDaoException("Cannot add constituency",e.getCause());
		}
	}

	@Override
	public Constituency getConsById(int consId) throws ElectionDaoException {
		try (Session session = DButil.getSession();) {
			session.beginTransaction();
			Constituency constituency = (Constituency) session.get(Constituency.class, consId);
			return constituency;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get constituency", e.getCause());
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Constituency getConsByName(String consName) throws ElectionDaoException {
		try (Session session = DButil.getSession();) {
			session.beginTransaction();
			String sql = "select * from constituency C WHERE C.name = ?";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter(1, consName);
			query.addEntity(Constituency.class);
			List<Constituency> constituency = query.list();
			return constituency.get(0);
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get constituency results", e.getCause());
		}
	}

	@Override
	public void deleteConstituency(int consId) throws ElectionDaoException {
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.remove(getConsById(consId));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot delete constituency", e.getCause());
		}
		
	}

	@Override
	public void updateConstituency(Constituency constituency) throws ElectionDaoException {
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.update(constituency);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot update constituency", e.getCause());
		}		
	}

}
