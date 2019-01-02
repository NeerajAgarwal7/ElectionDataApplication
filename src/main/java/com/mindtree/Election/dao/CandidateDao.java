package com.mindtree.Election.dao;

import java.util.List;

import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;

public interface CandidateDao {

	public int addCandidate(Candidate candidate) throws ElectionDaoException;
	public Candidate getCandidate(int candId) throws ElectionDaoException;
	public void deleteCandidate(int candId) throws ElectionDaoException;
	public void updateCandidate(Candidate candidate) throws ElectionDaoException;
	public List<Candidate> getCandidateByConstituencyId(int consId) throws ElectionDaoException;
	public List<Candidate> getCandByPartyName(String party) throws ElectionDaoException;
	public List<Candidate> getCandByConstituencyName(Constituency cons) throws ElectionDaoException;
	public List<Candidate> getCandidateByPartyCons(String party, Constituency cons) throws ElectionDaoException;
	
}