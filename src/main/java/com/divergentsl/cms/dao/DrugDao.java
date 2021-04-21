package com.divergentsl.cms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergentsl.cms.databaseconnection.IDatabaseManager;
import com.divergentsl.cms.dto.DrugDto;


public class DrugDao {
	
	IDatabaseManager DatabaseManager;
	
	public DrugDao(IDatabaseManager DatabaseManager){
		this.DatabaseManager=DatabaseManager;
		
	}
	
	//add
	public int addDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("insert into drug values ('"+drugid+"','"+drugname+"','"+drugdescription+"','"+drugquantity+"','"+drugprice+"')");
		
		
	}

	//delete
	public int deleteDrug(String drugid) throws SQLException{

		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		
		return st.executeUpdate("delete from drug where drugid='"+drugid+"' ");
		
	}
	
	//update
	public int updateDrug(String drugid,String drugname,String drugdescription, String drugquantity,String drugprice) throws SQLException {
		
		Connection con = null;
		Statement st= null;
		
		con=DatabaseManager.getConnection();
		st=con.createStatement();
		return st.executeUpdate("update drug set drugname='"+drugname+"', drugdescription='"+drugdescription+"',drugquantity='"+drugquantity+"',drugprice='"+drugprice+"' where drugid='"+drugid+"'");
		
		
	}
	
	//list of drug
	public List<DrugDto> listDrug() throws SQLException {
		Connection con = null;
		Statement st = null;

		con = DatabaseManager.getConnection();
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
