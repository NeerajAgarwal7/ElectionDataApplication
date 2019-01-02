package com.mindtree.Election.service;

import java.util.List;

import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionServiceException;

public interface UserService {

	public String addCandToNewCons(int candId,Constituency cons) throws ElectionServiceException;
	public String addCandToExistingCons(int candId,int consId) throws ElectionServiceException;
	public List<Candidate> getCandByConsId(int consId) throws ElectionServiceException;
	public List<Candidate> getCandByParty(String party) throws ElectionServiceException;
	public List<Candidate> getCandByConsName(String consName) throws ElectionServiceException;
	public List<Candidate> getCandByPartyCons(String party,String consName) throws ElectionServiceException;
	
}
