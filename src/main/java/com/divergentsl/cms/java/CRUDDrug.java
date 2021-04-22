package com.divergentsl.cms.java;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.DrugDao;
import com.divergentsl.cms.databaseconnection.DatabaseManager;
import com.divergentsl.cms.dto.DrugDto;

/**
 * Class for CRUD Drug
 * @author Pooja Patidar
 *
 */
@Component
public class CRUDDrug {
	public static final Logger myLogger=Logger.getLogger("com.mycompany.myapp");
	
	@Autowired
	private DrugDao drugdao;
	
	
	public void crudDrug() {

		exit: while (true) {
			System.out.println("-----CRUDDrug----");
			System.out.println("1.Add");
			System.out.println("2.Delete");
			System.out.println("3.Update");
			System.out.println("4.List of drug");
			System.out.println("5.Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				addDrug();
				break;
			case 2:
				deleteDrug();
				break;
			case 3:
				updateDrug();
				break;
			case 4:
				listDrug();
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
	 * method to insert the drug
	 */
	public void addDrug() {
		
		System.out.println("----Add Drug-----");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();

		System.out.println("Enter drug name=");
		String drugname = sc.nextLine();

		System.out.println("Enter drug description=");
		String drugdescription = sc.nextLine();

		System.out.println("Enter quantity=");
		String drugquantity = sc.nextLine();

		System.out.println("Enter drugprice=");
		String drugprice = sc.nextLine();

		//DrugDao drugdao = new DrugDao(new DatabaseManager());

		try {
			drugdao.addDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			
			System.out.println("Added Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to delete the drug
	 */
	public void deleteDrug() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----Delete Drug------");
		System.out.println("Enter the drug id=");
		String drugid = sc.nextLine();

		//DrugDao drugdao = new DrugDao(new DatabaseManager());

		try {
			drugdao.deleteDrug(drugid);
			
			System.out.println("Deleted Successfully");
		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

	/**
	 * method to update the drug
	 */
	public void updateDrug() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("----Update Drug----");
		System.out.println("Enter drug id=");
		String drugid = sc.nextLine();
		System.out.println("Enter new drug name=");
		String drugname = sc.nextLine();
		System.out.println("Enter new drug description=");
		String drugdescription = sc.nextLine();
		System.out.println("Enter new drug quantity=");
		String drugquantity = sc.nextLine();
		System.out.println("Enter new drug price=");
		String drugprice = sc.nextLine();

		//DrugDao drugdao = new DrugDao(new DatabaseManager());
		try {
			drugdao.updateDrug(drugid, drugname, drugdescription, drugquantity, drugprice);
			
			System.out.println("Updated Successfully");
		} catch (SQLException e) {
			// TODO: handle exception
			myLogger.log(Level.INFO,e.getMessage());
		}

	}

	/**
	 * method to show the list of drug
	 */
	public void listDrug() {
		
		System.out.println("----List of Drug----");
		try {
			//DrugDao drugDao = new DrugDao(new DatabaseManager());
			List<DrugDto> dtos = drugdao.listDrug();

			for (DrugDto drugDto : dtos) {
				System.out.printf(" %10s %30s %15s  %20s %20s ", drugDto.getDrugid(), drugDto.getDrugname(),
						drugDto.getDrugdescription(), drugDto.getDrugquantity(), drugDto.getDrugprice());
				System.out.println("\n");
			}

		} catch (SQLException e) {
			myLogger.log(Level.INFO,e.getMessage());
		}
	}

}
