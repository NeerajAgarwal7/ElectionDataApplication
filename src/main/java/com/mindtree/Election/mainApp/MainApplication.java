package com.mindtree.Election.mainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.mindtree.Election.entity.Candidate;
import com.mindtree.Election.entity.Constituency;
import com.mindtree.Election.exceptions.AppException;
import com.mindtree.Election.service.CandidateService;
import com.mindtree.Election.service.ConstituencyService;
import com.mindtree.Election.service.UserService;
import com.mindtree.Election.service.electionServiceImpl.CandidateServiceImpl;
import com.mindtree.Election.service.electionServiceImpl.ConstituencyServiceImpl;
import com.mindtree.Election.service.electionServiceImpl.UserServiceImpl;
import com.mindtree.Election.utility.DataRWutil;

//Console based application for Election data management s/w

public class MainApplication {

	public static CandidateService CS = new CandidateServiceImpl();
	public static ConstituencyService ConS = new ConstituencyServiceImpl();
	public static UserService US = new UserServiceImpl();
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws AppException {

		System.out.println("***************************************************************************************");
		System.out.println("*************************************Welcome*******************************************");
		System.out.println("***************************************************************************************");
		System.out.println("");

		while (true) {
			try {
				System.out.println("1 - Admin\n2 - User\n3 - Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(bf.readLine());

				switch (choice) {
				case 1:
					showAdminMenu(); 	//calls function to display the admin menu
					break;
				case 2:
					showUserMenu();		//calls function to display the user menu
					break;
				case 3:
					System.out.println("Bye...");	//Exit out of the console Application
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				throw new AppException("Enter valid input", e.getCause());
			} catch (IOException e) {
				throw new AppException("Cannot read data", e.getCause());
			}
		}
	}

//	Function for displaying the Admin menu
	
	private static void showAdminMenu() throws AppException {
		System.out.println("***************************************************************************************");
		System.out.println("**********************************Welcome Admin****************************************");
		System.out.println("***************************************************************************************");
		System.out.println("");

		while (true) {
			try {
				System.out.println("1 - Constituency\n2 - Candidate\n3 - Go to previous menu\n4 - Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(bf.readLine());
				switch (choice) {
				case 1:
					showConstituencyMenu();	//calls function to display the Constituency data manipulation menu
					break;
				case 2:
					showCandidateMenu();	//calls function to display the Candidate data manipulation menu
					break;
				case 3:
					return;					// Go back to the previous menu
				case 4:
					System.out.println("Bye...");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				throw new AppException("Enter valid input", e.getCause());
			} catch (IOException e) {
				throw new AppException("Cannot read data", e.getCause());
			}
		}

	}

//	Function for displaying the Candidate data manipulation menu
	
	private static void showCandidateMenu() throws AppException {
		System.out.println("***************************************************************************************");
		System.out.println("**********************************Candidate menu***************************************");
		System.out.println("***************************************************************************************");
		System.out.println("");

		while (true) {
			try {
				System.out.println(
						"1 - Add new Candidate\n2 - Get candidate by his Id\n3 - Delete candiadte\n4 - Update candidate data\n5 - Go to previous menu\n6 - Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(bf.readLine());

				switch (choice) {
				
				//	Case 1 : adds candidate data into database
				case 1:
					Candidate candidate = DataRWutil.readCandData();
					int id = CS.addnewCandiadte(candidate);
					System.out.println("Candidate added with Id : " + id);
					break;

					
				//	Case 2 : Display data of a particular candidate
				case 2:
					
					/*
					 * Statements to display candidate data in a tabular format
					 * This is achieved using the System.out.format() function
					 */ 
					
					System.out.print("Enter the candidate Id : ");
					int candId = Integer.parseInt(bf.readLine());
					Candidate cand = CS.getCandById(candId);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s", "Candidate_id", "Name", "Party", "Constituency_id");
					System.out.println("");
					System.out.println("****************************************************************************");
					DataRWutil.displayCandidate(cand);
					System.out.println("");
					System.out.println("****************************************************************************");
					break;
					
				//	Case 3 : Delete a particular candidates data
				case 3:
					System.out.print("Enter the candidate Id : ");
					int canId = Integer.parseInt(bf.readLine());
					System.out.println(CS.deleteCand(canId));
					break;

				case 4:
					System.out.print("Enter the candidate Id whose details have to be updated : ");
					int can = Integer.parseInt(bf.readLine());
					Candidate cand1 = DataRWutil.readCandData();
					cand1.setId(can);
					CS.updateCand(cand1);
					break;

				case 5:
					return;

				case 6:
					System.out.println("Bye...");
					System.exit(0);
				default:
					System.out.println("Enter valid input");
				}
			} catch (NumberFormatException e) {
				throw new AppException("Enter valid input", e.getCause());
			} catch (IOException e) {
				throw new AppException("Cannot read data", e.getCause());
			}
		}
	}

//	Function for displaying the Constituency data manipulation menu
	
	private static void showConstituencyMenu() throws AppException {
		System.out.println("***************************************************************************************");
		System.out.println("*********************************Constituency menu*************************************");
		System.out.println("***************************************************************************************");
		System.out.println("");
		while (true) {
			try {
				System.out.println(
						"1 - Add new Constituency\n2 - Get Constituency by its Id\n3 - Get Constituency by name\n4 - Delete Constituency\n5 - Update Constituency data\n6 - Go to previous menu\n7 - Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(bf.readLine());
				switch (choice) {
				case 1:
					Constituency cons = DataRWutil.readConsData();
					System.out.println(ConS.addNewConstituency(cons));
					break;

				case 2:
					System.out.println("Enter constituency id : ");
					int id = Integer.parseInt(bf.readLine());
					Constituency constituency = ConS.getConstituencyById(id);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s", "Constituency_id","Name");
					System.out.println("");
					System.out.println("****************************************************************************");
					System.out.format("%-16d%-16s", constituency.getId(),constituency.getName());
					System.out.println("");
					System.out.println("****************************************************************************");
					break;

				case 3:
					System.out.println("Enter constituency name : ");
					String name = bf.readLine();
					Constituency const1 = ConS.getConstituencyByName(name);
					System.out.println(const1);
					break;

				case 4:
					System.out.println("Enter constituency id : ");
					int id1 = Integer.parseInt(bf.readLine());
					System.out.println(ConS.deleteCons(id1));
					break;

				case 5:
					Constituency cons1 = DataRWutil.readConsData();
					System.out.println(ConS.updateCons(cons1));
					break;

				case 6:
					return;

				case 7:
					System.out.println("Bye...");
					System.exit(0);
				}

			} catch (NumberFormatException e) {
				throw new AppException("Enter valid input", e.getCause());
			} catch (IOException e) {
				throw new AppException("Cannot read data", e.getCause());
			}
		}
	}

//	Function for displaying the User menu for different data retrieval functions 
	
	private static void showUserMenu() throws AppException {
		System.out.println("***************************************************************************************");
		System.out.println("***********************************Welcome User****************************************");
		System.out.println("***************************************************************************************");
		System.out.println("");

		while (true) {
			try {
				System.out.println("1 - Insert candidate into new constituency\n"
						+ "2 - Insert candidate into existing constituency\n"
						+ "3 - Display candidates for given constituency id\n"
						+ "4 - Display candidates for given party\n"
						+ "5 - Display candidates for given constituency name\n"
						+ "6 - Display candidates for given party in a given constituency\n"
						+ "7 - Go to previous menu\n" + "8 - Exit");
				System.out.print("Enter your choice : ");
				int choice = Integer.parseInt(bf.readLine());

				switch (choice) {
				case 1:
					System.out.println("Enter new Constituency data : ");
					Constituency cons = DataRWutil.readConsData();
					System.out.println("Enter candidate id who has to be added to this constituency : ");
					int id = Integer.parseInt(bf.readLine());
					System.out.println(US.addCandToNewCons(id, cons));
					break;

				case 2:
					System.out.println("Enter Constituency Id : ");
					int consId = Integer.parseInt(bf.readLine());
					System.out.println("Enter candidate id who has to be added to this constituency : ");
					int candId = Integer.parseInt(bf.readLine());
					System.out.println(US.addCandToExistingCons(candId, consId));
					break;

				case 3:
					System.out.println("Enter Constituency Id : ");
					int consId1 = Integer.parseInt(bf.readLine());
					List<Candidate> resCand = US.getCandByConsId(consId1);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s", "Candidate_id", "Name", "Party", "Constituency_id");
					System.out.println("");
					System.out.println("****************************************************************************");
					resCand.forEach(c -> {
						DataRWutil.displayCandidate(c);
						System.out.println("");
					});
					System.out.println("****************************************************************************");
					break;

				case 4:
					System.out.println("Enter party name : ");
					String party = (bf.readLine());
					List<Candidate> resCand1 = US.getCandByParty(party);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s", "Candidate_id", "Name", "Party", "Constituency_id");
					System.out.println("");
					System.out.println("****************************************************************************");
					resCand1.forEach(c -> {
						DataRWutil.displayCandidate(c);
						System.out.println("");
					});
					System.out.println("****************************************************************************");
					break;

				case 5:
					System.out.println("Enter Constituency name : ");
					String consName = (bf.readLine());
					List<Candidate> resCand2 = US.getCandByConsName(consName);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s", "Candidate_id", "Name", "Party", "Constituency_id");
					System.out.println("");
					System.out.println("****************************************************************************");
					resCand2.forEach(c -> {
						DataRWutil.displayCandidate(c);
						System.out.println("");
					});
					System.out.println("****************************************************************************");
					break;

				case 6:
					System.out.println("Enter party name : ");
					String party1 = (bf.readLine());
					System.out.println("Enter Constituency name : ");
					String consName1 = (bf.readLine());
					List<Candidate> resCand3 = US.getCandByPartyCons(party1, consName1);
					System.out.println("****************************************************************************");
					System.out.format("%-16s%-16s%-16s%-16s", "Candidate_id", "Name", "Party", "Constituency_id");
					System.out.println("");
					System.out.println("****************************************************************************");
					resCand3.forEach(c -> {
						DataRWutil.displayCandidate(c);
						System.out.println("");
					});
					System.out.println("****************************************************************************");
					break;

				case 7:
					return;

				case 8:
					System.out.println("Bye...");
					System.exit(0);
				}

			} catch (NumberFormatException e) {
				throw new AppException("Enter valid input", e.getCause());
			} catch (IOException e) {
				throw new AppException("Cannot read data", e.getCause());
			}
		}

	}
}