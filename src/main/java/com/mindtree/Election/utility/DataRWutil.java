package com.mindtree.Election.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.AppException;

public class DataRWutil {
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static Candidate readCandData() throws AppException{
		
		try {
			Candidate cand = new Candidate();
			System.out.print("Enter candidate name : ");
			cand.setName(bf.readLine());
			System.out.println("Enter candidates party name : ");
			cand.setParty(bf.readLine());
			return cand;
		}catch (NumberFormatException e) {
			throw new AppException("Enter valid data",e.getCause());
		} catch (IOException e) {
			throw new AppException("Cannot read data",e.getCause());
		}
	}
	
	public static Constituency readConsData() throws AppException{
		
		try {
			Constituency constituency = new Constituency();
			System.out.println("Enter constituency code/id : ");
			constituency.setId(Integer.parseInt(bf.readLine()));
			System.out.println("Enter constituency name : ");
			constituency.setName(bf.readLine());
			
			return constituency;
		} catch (NumberFormatException e) {
			throw new AppException("Enter valid data",e.getCause());
		} catch (IOException e) {
			throw new AppException("Cannot read data",e.getCause());
		}
		
	}
	
	public static void displayCandidate(Candidate can) {
		System.out.format("%-16d%-16s%-16s", can.getId(),can.getName(),can.getParty());
		if(!(can.getConstituency()==null))
			System.out.format("%-16d", can.getConstituency().getId());
	}
	
}
