package com.divergentsl.cms.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

/**
 * Class for  H2DatabaseManager
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class H2DatabaseManager implements IDatabaseManager {

	public static String DB_URL = "jdbc:h2:~/test";

	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}