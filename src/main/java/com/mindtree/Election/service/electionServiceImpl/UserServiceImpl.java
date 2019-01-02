package com.mindtree.Election.service.electionServiceImpl;

import java.util.List;

import com.mindtree.Election.dao.CandidateDao;
import com.mindtree.Election.dao.ConstituencyDao;
import com.mindtree.Election.dao.electionDaoImpl.CandidateDaoImpl;
import com.mindtree.Election.dao.electionDaoImpl.ConstituencyDaoImpl;
import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;
import com.mindtree.Election.exceptions.ElectionServiceException;
import com.mindtree.Election.service.UserService;

public class UserServiceImpl implements UserService{
	
	public static CandidateDao CanD = new CandidateDaoImpl();
	public static ConstituencyDao ConsD = new ConstituencyDaoImpl();


	@Override
	public String addCandToNewCons(int candId, Constituency cons) throws ElectionServiceException {

		try {
			ConsD.addConstituency(cons);
			Candidate can = CanD.getCandidate(candId);
			can.setConstituency(cons);
			CanD.updateCandidate(can);
			return "Candidate successfully added to new Constituency";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public String addCandToExistingCons(int candId, int consId) throws ElectionServiceException {

		try {
			Candidate can = CanD.getCandidate(candId);
			Constituency con = ConsD.getConsById(consId);
			can.setConstituency(con);
			CanD.updateCandidate(can);
			return "Candidate successfully added to Existing Constituency";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Candidate> getCandByConsId(int consId) throws ElectionServiceException {

		try {
			List<Candidate> resCand = CanD.getCandidateByConstituencyId(consId);
			return resCand;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Candidate> getCandByParty(String party) throws ElectionServiceException {
		
		try {
			List<Candidate> resCand = CanD.getCandByPartyName(party);
			return resCand;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Candidate> getCandByConsName(String consName) throws ElectionServiceException {
		
		try {
			Constituency cons = ConsD.getConsByName(consName);
			List<Candidate> resCand = CanD.getCandByConstituencyName(cons);
			return resCand;
		}  catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

	@Override
	public List<Candidate> getCandByPartyCons(String party, String consName) throws ElectionServiceException {
		try {
			Constituency cons = ConsD.getConsByName(consName);
			List<Candidate> resCand = CanD.getCandidateByPartyCons(party, cons);
			return resCand;
		}  catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(),e.getCause());
		}
	}

}
