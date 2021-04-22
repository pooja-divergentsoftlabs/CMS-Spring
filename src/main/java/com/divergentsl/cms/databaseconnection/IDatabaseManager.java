package com.divergentsl.cms.databaseconnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for database connection
 * 
 * @author Pooja Patidar
 *
 */
public interface IDatabaseManager {
	
	String username = "root";
	
	String password = "root";
	
	String url = "jdbc:mysql://localhost:3306/clinic_management_system";
	
	public Connection getConnection() throws SQLException;
	
	

}
