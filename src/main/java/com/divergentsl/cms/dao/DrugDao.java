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
import com.divergentsl.cms.dto.DrugDto;

/**
 * Class for Drug Dao
 * @author Pooja Patidar
 *
 */
@Repository
public class DrugDao {
	
	@Autowired
	IDatabaseManager databaseManager;
	
	
	/**
	 * This method insert the drug
	 * @param drugid
	 * @param drugname
	 * @param drugdescription
	 * @param drugquantity
	 * @param drugprice
	 * @return It return 1 if drug successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int addDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into drug values ('"+drugid+"','"+drugname+"','"+drugdescription+"','"+drugquantity+"','"+drugprice+"')");
		
		
	}

	/**
	 * This method delete the drug
	 * @param drugid
	 * @return It return 1 if drug successfully added otherwise it returns 0
	 * @throws SQLException
	 */
	public int deleteDrug(String drugid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from drug where drugid='"+drugid+"' ");
		
	}
	
	/**
	 * This method update the drug of given id
	 * @param drugid
	 * @param drugname
	 * @param drugdescription
	 * @param drugquantity
	 * @param drugprice
	 * @return It return 1 if doctor successfully updated otherwise it returns 0
	 * @throws SQLException
	 */
	public int updateDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=databaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update drug set drugname='"+drugname+"', drugdescription='"+drugdescription+"',drugquantity='"+drugquantity+"',drugprice='"+drugprice+"' where drugid='"+drugid+"'");
		
		
	}
	
	/**
	 * This method shows the list of drug 
	 * @return It returns the list of drug
	 * @throws SQLException
	 */
	public List<DrugDto> listDrug() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from drug ");
		List<DrugDto> drugDtos = new ArrayList<DrugDto>();
		while (rs.next()) {
			DrugDto drugDto = new DrugDto();
			drugDto.setDrugid(rs.getString(1));
			drugDto.setDrugname(rs.getString(2));
			drugDto.setDrugdescription(rs.getString(3));
			drugDto.setDrugquantity(rs.getString(4));
			drugDto.setDrugprice(rs.getString(5));
			drugDtos.add(drugDto);

		}
		return drugDtos;

	}
	
	
	
}
