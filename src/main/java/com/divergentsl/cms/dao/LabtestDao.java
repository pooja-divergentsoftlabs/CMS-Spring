package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.LabtestDto;


public class LabtestDao {
	
	IDatabaseManager DatabaseManager;
	
	public LabtestDao(IDatabaseManager DatabaseManager){
		this.DatabaseManager=DatabaseManager;
		
	}
	
	//add
	public int addLabtest(String testid,String testname,String pid, String testfee) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into labtest values ('"+testid+"','"+testname+"','"+pid+"','"+testfee+"')");
		
		
	}

	//delete
	public int deleteLabtest(String testid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from labtest where testid='"+testid+"' ");
		
	}
	
	//update
	public int updateLabtest(String testid,String testname, String pid,String testfee) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update labtest set testname='"+testname+"',pid='"+pid+"',testfee='"+testfee+"' where testid='"+testid+"'");
		
		
	}
	
	//list of drug
	public List<LabtestDto> listLabtest() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = DatabaseManager.getConnection();
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
