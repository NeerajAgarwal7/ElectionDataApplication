package com.mindtree.Election.dao.electionDaoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mindtree.Election.dao.CandidateDao;
import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;
import com.mindtree.Election.utility.DButil;

@SuppressWarnings("deprecation")
public class CandidateDaoImpl implements CandidateDao {

	public int addCandidate(Candidate candidate) throws ElectionDaoException {
		try (Session session = DButil.getSession();) {
			session.beginTransaction();
			session.save(candidate);
			session.getTransaction().commit();
			Serializable id = session.getIdentifier(candidate);
			return (Integer) id;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot add candidate", e.getCause());
		}
	}

	public Candidate getCandidate(int candId) throws ElectionDaoException {

		try (Session session = DButil.getSession();) {
			session.beginTransaction();
			Candidate candidate = (Candidate) session.get(Candidate.class, candId);
			return candidate;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get candidate", e.getCause());
		}
	}

	public void deleteCandidate(int candId) throws ElectionDaoException {
		
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.remove(getCandidate(candId));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot delete candidate", e.getCause());
		}
		
	}

	public void updateCandidate(Candidate candidate) throws ElectionDaoException {
		
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			session.update(candidate);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot update candidate", e.getCause());
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Candidate> getCandidateByConstituencyId(int consId) throws ElectionDaoException{
		
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			String hql = "From Candidate where constituency="+consId;
			Query query = session.createQuery(hql);
			List<Candidate> resCand = query.list();
			return resCand;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get data",e.getCause());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Candidate> getCandByPartyName(String party) throws ElectionDaoException{
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			String hql = "From Candidate where party = '"+party+"'";
			Query query = session.createQuery(hql);
			List<Candidate> resCand = query.list();
			return resCand;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get data",e.getCause());
		}
	}
	
	public List<Candidate> getCandByConstituencyName(Constituency cons) throws ElectionDaoException{
		
			List<Candidate> resCand = getCandidateByConstituencyId(cons.getId());
			return resCand;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Candidate> getCandidateByPartyCons(String party, Constituency cons) throws ElectionDaoException{
		
		try(Session session = DButil.getSession()){
			session.beginTransaction();
			String hql = "From Candidate where constituency="+cons.getId()+" and Party = '"+party+"'";
			Query query = session.createQuery(hql);
			List<Candidate> resCand = query.list();
			return resCand;
		} catch (HibernateException e) {
			throw new ElectionDaoException("Cannot get data",e.getCause());
		}
	}
}