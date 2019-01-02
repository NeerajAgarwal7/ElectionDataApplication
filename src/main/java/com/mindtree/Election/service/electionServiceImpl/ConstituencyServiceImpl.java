package com.mindtree.Election.service.electionServiceImpl;

import com.mindtree.Election.dao.ConstituencyDao;
import com.mindtree.Election.dao.electionDaoImpl.ConstituencyDaoImpl;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.ElectionDaoException;
import com.mindtree.Election.exceptions.ElectionServiceException;
import com.mindtree.Election.service.ConstituencyService;

public class ConstituencyServiceImpl implements ConstituencyService{

	ConstituencyDao ConsD = new ConstituencyDaoImpl();
	
	@Override
	public String addNewConstituency(Constituency constituency) throws ElectionServiceException {
		try {
			ConsD.addConstituency(constituency);
			return "Constituency added successfully";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Constituency getConstituencyById(int consId) throws ElectionServiceException {
		try {
			Constituency cons = ConsD.getConsById(consId);
			return cons;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public Constituency getConstituencyByName(String consName) throws ElectionServiceException {
		try {
			Constituency cons = ConsD.getConsByName(consName);
			return cons;
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public String deleteCons(int consId) throws ElectionServiceException {
		try {
			ConsD.deleteConstituency(consId);
			return "Constituency details deleted successfully";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public String updateCons(Constituency constituency) throws ElectionServiceException {
		try {
			ConsD.updateConstituency(constituency);
			return "Constituency details updated successfully";
		} catch (ElectionDaoException e) {
			throw new ElectionServiceException(e.getMessage(), e.getCause());
		}
	}

}
