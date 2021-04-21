package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.AppointmentDto;


public class AppointmentDao {
	
	IDatabaseManager DatabaseManager;
	
	public AppointmentDao(IDatabaseManager DatabaseManager){
		this.DatabaseManager=DatabaseManager;
		
	}
	
	//add
	public int addAppointment(String appid,String pid,String pname, String appdate) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into appointment values ('"+appid+"','"+pid+"','"+pname+"','"+appdate+"')");
		
		
	}

	//delete
	public int deleteAppointment(String appid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from appointment where appid='"+appid+"' ");
		
	}
	
	//update
	public int updateAppointment(String appid,String pid, String pname,String appdate) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update appointment set pid='"+pid+"',pname='"+pname+"',appdate='"+appdate+"' where appid='"+appid+"'");
		
		
	}
	
	//list of drug
	public List<AppointmentDto> listAppointment() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = DatabaseManager.getConnection();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from appointment ");
		List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
		while (rs.next()) {
			AppointmentDto appointmentDto = new AppointmentDto();
			appointmentDto.setAppid(rs.getString(1));
			appointmentDto.setPid(rs.getString(2));
			appointmentDto.setPname(rs.getString(3));
			appointmentDto.setAppdate(rs.getString(4));
			appointmentDtos.add(appointmentDto);

		}
		return appointmentDtos;

	}
	
	
	
}
