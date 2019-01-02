package com.mindtree.Election.service.electionServiceImpl;

import com.mindtree.Election.dao.CandidateDao;
import com.mindtree.Election.dao.electionDaoImpl.CandidateDaoImpl;
import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.exceptions.ElectionDaoException;
import com.mindtree.Election.exceptions.ElectionServiceException;
import com.mindtree.Election.service.CandidateService;

public class CandidateServiceImpl implements CandidateService{

	public static CandidateDao CanD = new CandidateDaoImpl();
	
	@Override
	public int addnewCandiadte(Candidate candidate) throws ElectionServiceException {

		try {
			int id = CanD.addCandidate(candidate);
			return id;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Candidate getCandById(int candId) throws ElectionServiceException {

		try {
			Candidate cand = CanD.getCandidate(candId);
			return cand;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public String deleteCand(int candId) throws ElectionServiceException {
		
		try {
			CanD.deleteCandidate(candId);
			return "Candidate details deleted successfully";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public String updateCand(Candidate candidate) throws ElectionServiceException {
		
		try {
			CanD.updateCandidate(candidate);
			return "Candidate details updated successfully";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

}
