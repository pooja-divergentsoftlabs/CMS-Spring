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

import com.divergentsl.cms.dao.PatientDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.PatientDto;

/**
 * Class for CRUDPatient
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDPatient {
	public static final Logger myLogger= Logger.getLogger("com.mycompany.myapp");
	
	@Autowired
	private PatientDao patientDao;
	

	public void crudPatient() {

		exit: while (true) {
			
			System.out.println("------CRUD Patient-----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of patient");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addPatient();
				break;
			case 2:
				deletePatient();
				break;
			case 3:
				updatePatient();
				break;
			case 4:
				listPatient();
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
	 * method to insert the patient
	 */
	public void addPatient() {
		
		System.out.println("----Add Patient-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id=");
		String pid = sc.nextLine();

		System.out.println("Enter name=");
		String pname = sc.nextLine();

		System.out.println("Enter address=");
		String paddress = sc.nextLine();

		System.out.println("Enter contact number=");
		String pcontactnumber = sc.nextLine();

		System.out.println("Enter age=");
		String page = sc.nextLine();

		System.out.println("Enter weight=");
		String pweight = sc.nextLine();

		//PatientDao patientdao = new PatientDao(new DatabaseManager());

		try {
			patientDao.addPatient(pid, pname, paddress, pcontactnumber, page, pweight);
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to delete the patient
	 */
	public void deletePatient() {

		Scanner sc = new Scanner(System.in);
		System.out.println("-----Delete Patient------");
		System.out.println("Enter the patient id=");
		String pid = sc.nextLine();

		//PatientDao patientdao = new PatientDao(new DatabaseManager());

		try {
			patientDao.deletePatient(pid);
			System.out.println("Deleted Successfully");
			
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

	/**
	 * method to update the patient
	 */
	public void updatePatient() {

		Scanner sc = new Scanner(System.in);
		System.out.println("-----Update Patient------");
		System.out.println("Enter patient id=");
		String pid = sc.nextLine();
		System.out.println("Enter new patient name=");
		String pname = sc.nextLine();
		System.out.println("Enter new patient address=");
		String paddress = sc.nextLine();
		System.out.println("Enter new patient contactnumber=");
		String pcontactnumber = sc.nextLine();
		System.out.println("Enter new patient age=");
		String page = sc.nextLine();
		System.out.println("Enter new patient weight=");
		String pweight = sc.nextLine();

		//PatientDao patientDao = new PatientDao(new DatabaseManager());

		try {
			patientDao.updatePatient(pid, pname, paddress, pcontactnumber, page, pweight);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to list of patient
	 */
	public void listPatient() {
		
		System.out.println("----List of Patient----");
		try {
			//PatientDao patientdao = new PatientDao(new DatabaseManager());
			List<PatientDto> dtos = patientDao.listPatient();

			for (PatientDto patientDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s %20s %20s ", patientDto.getPid(), patientDto.getPname(),
						patientDto.getPaddress(), patientDto.getPcontactnumber(), patientDto.getPage(),
						patientDto.getPweight());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

}
