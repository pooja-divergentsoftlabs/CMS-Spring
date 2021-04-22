package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.LabtestDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.LabtestDto;

/**
 * Class for CRUDLabtest
 * 
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDLabtest {
	public static final Logger myLogger= Logger.getLogger("com.mycompany.myapp");
	
	@Autowired
	private LabtestDao labtestdao;
	
	public void crudLabtest() {

		exit: while (true) {
	
			System.out.println("------CRUD Labtest-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of labtest");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addLabtest();
				break;
			case 2:
				deleteLabtest();
				break;
			case 3:
				updateLabtest();
				break;
			case 4:
				listLabtest();
				break;
			case 5:
				break exit;
				default:
					myLogger.log(Level.INFO,"Invalid Input");
					break;

			}

		}
	}

	/**
	 * method to add labtest
	 */
	public void addLabtest() {
		
		System.out.println("----Add Labtest-----");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter test id=");
		String testid = sc.nextLine();

		System.out.println("Enter test name=");
		String testname = sc.nextLine();

		System.out.println("Enter patient id=");
		String pid = sc.nextLine();

		System.out.println("Enter test fee=");
		String testfee = sc.nextLine();

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.addLabtest(testid, testname, pid, testfee);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to delete the labtest
	 */
	public void deleteLabtest() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Delete Labtest------");
		System.out.println("Enter the test id=");
		String testid = sc.nextLine();

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.deleteLabtest(testid);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

	/**
	 * method to update the labtest
	 */
	public void updateLabtest() {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Labtest----");
		System.out.println("Enter test id=");
		String testid = sc.nextLine();
		System.out.println("Enter new test name=");
		String testname = sc.nextLine();
		System.out.println("Enter new patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new test fee=");
		String testfee = sc.nextLine();

		//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());

		try {
			labtestdao.updateLabtest(testid, testname, pid, testfee);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to list the labtest
	 */
	public void listLabtest() {
		
		System.out.println("----List of Labtest----");
		try {
			//LabtestDao labtestdao = new LabtestDao(new DatabaseManager());
			List<LabtestDto> dtos = labtestdao.listLabtest();
			// System.out.printf("id name\t pid\t fees\n ");

			for (LabtestDto labtestDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s ", labtestDto.getTestid(), labtestDto.getTestname(),
						labtestDto.getPid(), labtestDto.getTestfee());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

}
