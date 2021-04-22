package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class for Doctor Login
 * @author Pooja Patidar
 *
 */
@Component
public class DoctorLogin {
	public static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");

	
	@Autowired
	CRUDPatient crudPatient;
	@Autowired
	CRUDDoctor crudDoctor;
	@Autowired
	CRUDDrug crudDrug;
	@Autowired
	CRUDLabtest crudLabtest;
	@Autowired 
	CRUDAppointment crudAppointment;
	

	public void doctorPanel() {
		

		Scanner sc = new Scanner(System.in);

		exit: while (true) {
			
			
			System.out.println("--------Doctor Panel-------");
			System.out.println("1.List of Patient");
			System.out.println("2.List of appointments booked");
			System.out.println("3.List of Lab Test");
			System.out.println("4.List of Drugs Available");
			System.out.println("5.Exit");
			
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				crudPatient.listPatient();
				break;
			case 2:
				crudAppointment.listAppointment();
				break;
			case 3:
				crudLabtest.listLabtest();
				break;
			case 4:
				crudDrug.listDrug();
				break;
			case 5:
				break exit;
				default:
					myLogger.log(Level.INFO,"Invalid Input");
					break;

			}
		}

	}
}
