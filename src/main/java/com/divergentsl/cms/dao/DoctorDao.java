package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.DoctorDto;


public class DoctorDao {

	IDatabaseManager databaseManager;

	public DoctorDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	// add
	public int addDoctor(String did, String dname, String dspeciality, String dcontactnumber, String dfees)
			throws SQLException {

		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();

		return st.executeUpdate("insert into doctor values ('" + did + "','" + dname + "','" + dspeciality + "','"
				+ dcontactnumber + "','" + dfees + "')");

	}

	// delete
	public int deleteDoctor(String did) throws SQLException {

		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();

		return st.executeUpdate("delete from doctor where did='" + did + "'");

	}

	// update
	public int updateDoctor(String did, String dname, String dspeciality, String dcontactnumber, String dfees ) throws SQLException{
		
		Connection con = null;
		Statement st = null;
		
		con = databaseManager.getConnection();
		st = con.createStatement();
		
		return st.executeUpdate("update doctor set dname='"+dname+"', dspeciality='"+dspeciality+"',dcontactnumber='"+dcontactnumber+"',dfees='"+dfees+"' where did='"+did+"'  ");
	}
	
	
	//
	// list of patients
	public List<DoctorDto> listDoctor() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from doctor ");
		List<DoctorDto> doctorDtos = new ArrayList<DoctorDto>();
		while (rs.next()) {
			DoctorDto doctorDto = new DoctorDto();
			doctorDto.setDid(rs.getString(1));
			doctorDto.setDname(rs.getString(2));
			doctorDto.setDspeciality(rs.getString(3));
			doctorDto.setDcontactnumber(rs.getString(4));
			doctorDto.setDfees(rs.getString(5));
			doctorDtos.add(doctorDto);

		}
		return doctorDtos;

	}

	
	
	
	

}