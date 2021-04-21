package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.divergentsl.cms.dao.DoctorDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.DoctorDto;


public class CRUDDoctor {
	public static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");

	
	private static DoctorDao doctordao;
	
	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		//doctordao = context.getBean("doctordao", DoctorDao.class);
		doctordao =(DoctorDao)context.getBean("doctordao");
	}
	
	public static void crudDoctor() {
		
		exit: while (true) {
			
			System.out.println("-----CRUDDoctor----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of doctor");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addDoctor();
				break;
			case 2:
				deleteDoctor();
				break;
			case 3:
				updateDoctor();
				break;
			case 4:
				listDoctor();
				break;
			case 5:
				break exit;
				
				default:
					myLogger.log(Level.INFO,"Invalid Input");
					break;
			}

		}
	}

	// add
	public static void addDoctor() {
		
		myLogger.log(Level.INFO,"-------Add Doctor-----");
		//System.out.println("----Add Doctor----");
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter id=");
		String did = sc.nextLine();

		System.out.println("Enter name=");
		String dname = sc.nextLine();

		System.out.println("Enter speciality=");
		String dspeciality = sc.nextLine();

		System.out.println("Enter contact number=");
		String pcontactnumber = sc.nextLine();

		System.out.println("Enter fees=");
		String dfees = sc.nextLine();

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());

		try {
			doctordao.addDoctor(did, dname, dspeciality, pcontactnumber, dfees);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	// delete
	public static void deleteDoctor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Delete Doctor----");
		System.out.println("Enter the id=");
		String did = sc.nextLine();

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());
		try {
			doctordao.deleteDoctor(did);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	// update
	public static void updateDoctor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Doctor----");
		System.out.println("Enter the id =");
		String did = sc.nextLine();
		System.out.println("Enter new name=");
		String dname = sc.nextLine();
		System.out.println("Enter new doctor speciality=");
		String dspeciality = sc.nextLine();
		System.out.println("Enter new doctor contactnumber=");
		String dcontactnumber = sc.nextLine();
		System.out.println("Enter new doctor fees=");
		String dfees = sc.nextLine();

//		DoctorDao doctordao = new DoctorDao(new DatabaseManager());
		try {
			doctordao.updateDoctor(did, dname, dspeciality, dcontactnumber, dfees);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	// list of doctor
	public static void listDoctor() {
		System.out.println("----List of Doctor----");
		//myLogger.log(Level.INFO,"-------List of Doctor-----");

		try {
//			DoctorDao doctordao = new DoctorDao(new DatabaseManager());
			List<DoctorDto> dtos = doctordao.listDoctor();

			for (DoctorDto doctorDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s %20s", doctorDto.getDid(), doctorDto.getDname(),
						doctorDto.getDspeciality(), doctorDto.getDcontactnumber(), doctorDto.getDfees());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}
}
