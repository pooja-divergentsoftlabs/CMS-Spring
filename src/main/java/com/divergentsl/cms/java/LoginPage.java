package com.divergentsl.cms.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class for Login Page
 * 
 * @author Pooja Patidar
 *
 */
@Component
public class LoginPage {
	public static final Logger myLogger = Logger.getLogger("com.mycompany.myapp");
	
	
	@Autowired
	AdminPanel adminPanel;
	@Autowired
	DoctorLogin doctorLogin;

	public void loginPage() {

		exit: while (true) {
		
			System.out.println("------Clinic Management System-------");
			System.out.println("------LOGIN PAGE-----");
			System.out.println("1.Admin");
			System.out.println("2.Doctor");
			System.out.println("3.Exit");
			

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice=");
			int input = sc.nextInt();

			switch (input) {

			case 1:
				if(adminLogin()) {
				adminPanel.adminPanel();
				}
				else {
					myLogger.log(Level.INFO,"Wrong id/password");
					//System.out.println("Wrong id/password");
				}
				break;

			case 2:
				if(doctorLogin()) {
					doctorLogin.doctorPanel();
				}else {
					myLogger.log(Level.INFO,"Wrong id/password");
					//System.out.println("Wrong id/password");
				}
				break;

			case 3:
				myLogger.log(Level.INFO,"-----Exit-----");
				//System.out.println("----EXIT----");
				break exit;
				
				default:
					myLogger.log(Level.INFO,"Invalid Input");
					break;

			}
		}
	}
	
	
	 public static boolean adminLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password=");
	        String password = sc.nextLine();

	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM adminn where a_username = '"+username+"' && a_password = '"+password+"'");
	            if(rs.next()){
	           
	               System.out.println("Login Successful");
	                return true;
	            }
	            else{
	            	myLogger.log(Level.INFO,"Wrong username/password");
	                
	                return false;
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	        	myLogger.log(Level.INFO,e.getMessage());
	        }


	        return false;
	    }
	 
	 
	 public static boolean doctorLogin(){
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Enter username=");
	        String username = sc.nextLine();

	        System.out.println("Enter password");
	        String password = sc.nextLine();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic_management_system","root","root");
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM doctorlogin where d_username='"+username+"'&& d_password='"+password+"' ");
	            if(rs.next()){
	            	
	                System.out.println("Login successful");
	                return true;
	            }
	            else{
	            	myLogger.log(Level.INFO,"Wrong username/password");
	               // System.out.println("Wrong username/password");
	                return false;
	            }
	        } catch (ClassNotFoundException e) {
	        	myLogger.log(Level.INFO,e.getMessage());
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return false;
	    }

	 
	 
	 
	 
}
	
	
	 
