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
import com.divergentsl.cms.dto.PatientDto;

/**
 * Class for Patient Dao
 * 
 * @author Pooja Patidar
 *
 */
@Repository
public class PatientDao {
	
	@Autowired
	IDatabaseManager databaseManager;



	/**
	 *  This method insert the patient
	 * @param pid
	 * @param pname
	 * @param paddress
	 * @param pcontactnumber
	 * @param page
	 * @param pweight
	 * @return It return 1 if patient successfully added otherwise it returns 0 
	 * @throws SQLException
	 */
	public int addPatient(String pid, String pname, String paddress, String pcontactnumber, String page, String pweight)
			throws SQLException {

		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();

		return st.executeUpdate("insert into patient values ('" + pid + "','" + pname + "','" + paddress + "','"
				+ pcontactnumber + "','" + page + "','" + pweight + "')");

	}

	/**
	 * This method delete the doctor
	 * @param pid
	 * @return It return 1 if patient successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deletePatient(String pid) throws SQLException {

		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();

		return st.executeUpdate("delete from patient where pid='" + pid + "'");
	}

	/**
	 * This method update the patient of given id
	 * @param pid
	 * @param pname
	 * @param paddress
	 * @param pcontactnumber
	 * @param page
	 * @param pweight
	 * @return It return 1 if patient successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updatePatient(String pid, String pname, String paddress, String pcontactnumber, String page,
			String pweight) throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("update patient set pname='" + pname + "',paddress='" + paddress + "',pcontactnumber='"
				+ pcontactnumber + "',page='" + page + "',pweight='" + pweight + "' where pid='" + pid + "' ");

	}

	/**
	 * This method shows the list of patient 
	 * @return It returns the list of patient 
	 * @throws SQLException
	 */
	public List<PatientDto> listPatient() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from patient ");
		List<PatientDto> patientDtos = new ArrayList<PatientDto>();
		while (rs.next()) {
			PatientDto patientDto = new PatientDto();
			patientDto.setPid(rs.getString(1));
			patientDto.setPname(rs.getString(2));
			patientDto.setPaddress(rs.getString(3));
			patientDto.setPcontactnumber(rs.getString(4));
			patientDto.setPage(rs.getString(5));
			patientDto.setPweight(rs.getString(6));
			patientDtos.add(patientDto);

		}
		return patientDtos;

	}

}
