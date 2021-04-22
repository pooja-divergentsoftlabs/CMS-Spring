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
import com.divergentsl.cms.dto.AppointmentDto;
/**
 * 
 * Class for AppointmentDao
 * 
 * @author Pooja Patidar
 *
 */

@Repository
public class AppointmentDao {
	
	@Autowired
	IDatabaseManager databaseManager;
	
	
	/**
	 * This method insert the appointment
	 * @param appid
	 * @param pid
	 * @param pname
	 * @param appdate
	 * @return It return 1 if appointment successfully added otherwise it returns 0 
	 * @throws SQLException
	 */
	public int addAppointment(String appid,String pid,String pname, String appdate) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into appointment values ('"+appid+"','"+pid+"','"+pname+"','"+appdate+"')");
		
		
	}

	/**
	 * This method delete the appointment of given id
	 * @param appid
	 * @return It return 1 if appointment successfully deleted otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteAppointment(String appid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from appointment where appid='"+appid+"' ");
		
	}
	
	/**
	 * This method update the appointment of given id
	 * @param appid
	 * @param pid
	 * @param pname
	 * @param appdate
	 * @return It return 1 if appointment successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateAppointment(String appid,String pid, String pname,String appdate) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update appointment set pid='"+pid+"',pname='"+pname+"',appdate='"+appdate+"' where appid='"+appid+"'");
		
		
	}
	
	/**
	 * This method shows the list of appointment 
	 * @return It returns the list of appointment
	 * @throws SQLException
	 */
	public List<AppointmentDto> listAppointment() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
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
