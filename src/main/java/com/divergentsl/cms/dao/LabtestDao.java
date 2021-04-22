package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.LabtestDto;

/**
 * 
 * Class for Labtest Dao
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class LabtestDao {
	
	@Autowired
	IDatabaseManager databaseManager;
	
	
	/**
	 * This method insert the labtest
	 * @param testid
	 * @param testname
	 * @param pid
	 * @param testfee
	 * @return It return 1 if labtest successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int addLabtest(String testid,String testname,String pid, String testfee) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into labtest values ('"+testid+"','"+testname+"','"+pid+"','"+testfee+"')");
		
		
	}

	/**
	 * This method delete the labtest
	 * @param testid
	 * @return It return 1 if labtest successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteLabtest(String testid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from labtest where testid='"+testid+"' ");
		
	}
	
	/**
	 * This method update the labtest
	 * @param testid
	 * @param testname
	 * @param pid
	 * @param testfee
	 * @return It return 1 if drug successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateLabtest(String testid,String testname, String pid,String testfee) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update labtest set testname='"+testname+"',pid='"+pid+"',testfee='"+testfee+"' where testid='"+testid+"'");
		
		
	}
	
	/**
	 * This method shows the list of labtest 
	 * @return It returns the list of labtest
	 * @throws SQLException
	 */
	public List<LabtestDto> listLabtest() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from labtest ");
		List<LabtestDto> labtestDtos = new ArrayList<LabtestDto>();
		while (rs.next()) {
			LabtestDto labtestDto = new LabtestDto();
			labtestDto.setTestid(rs.getString(1));
			labtestDto.setTestname(rs.getString(2));
			labtestDto.setPid(rs.getString(3));
			labtestDto.setTestfee(rs.getString(4));
			labtestDtos.add(labtestDto);

		}
		return labtestDtos;

	}
	
	
	
}
