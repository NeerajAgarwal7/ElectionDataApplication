package com.mindtree.Election.service;

import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionServiceException;

public interface ConstituencyService {

	public String addNewConstituency(Constituency constituency) throws ElectionServiceException;
	public Constituency getConstituencyById(int consId) throws ElectionServiceException;
	public Constituency getConstituencyByName(String consName) throws ElectionServiceException;
	public String deleteCons(int consId) throws ElectionServiceException;
	public String updateCons(Constituency constituency) throws ElectionServiceException;
}
