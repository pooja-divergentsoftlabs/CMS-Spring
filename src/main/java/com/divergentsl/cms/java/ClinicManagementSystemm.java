package com.divergentsl.cms.java;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Main class for Clinic Management System
 * @author Pooja Patidar
 *
 */
public class ClinicManagementSystemm {

	
	public static void main(String args[]) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		LoginPage loginPage = context.getBean(LoginPage.class);
	
		loginPage.loginPage();
		
	}
	}


