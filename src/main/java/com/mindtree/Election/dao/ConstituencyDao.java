package com.mindtree.Election.dao;

import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;

public interface ConstituencyDao {

	public void addConstituency(Constituency constituency) throws ElectionDaoException;
	public Constituency getConsById(int consId) throws ElectionDaoException;
	public Constituency getConsByName(String consName) throws ElectionDaoException;
	public void deleteConstituency(int consId) throws ElectionDaoException;
	public void updateConstituency(Constituency constituency) throws ElectionDaoException;
	
}
