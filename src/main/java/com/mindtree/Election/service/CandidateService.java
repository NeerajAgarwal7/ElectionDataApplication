package com.mindtree.Election.service;

import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.exceptions.ElectionServiceException;

public interface CandidateService {

	public int addnewCandiadte(Candidate candidate) throws ElectionServiceException;
	public Candidate getCandById(int candId) throws ElectionServiceException;
	public String deleteCand(int candId) throws ElectionServiceException;
	public String updateCand(Candidate candidate) throws ElectionServiceException;
	
}
