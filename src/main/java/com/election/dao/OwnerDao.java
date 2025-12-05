package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.OwnerBean;

public class OwnerDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}

	public static boolean checkOwnerDetails(OwnerBean ownerbean) {

		if (con == null) {
			getConnection();
		}
		boolean existsVal = false;
		try {
			pst = con.prepareStatement(
					"select * from owners where owner_name = ? and owner_address = ? and owner_contact = ?");
			pst.setString(1, ownerbean.getoName());
			pst.setString(2, ownerbean.getoAddress());
			pst.setString(3, ownerbean.getoContact());
			rs = pst.executeQuery();

			while (rs.next()) {
				existsVal = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return existsVal;
	}

	public static boolean insertOwner(OwnerBean ownerBean) {

		if (con == null) {
			getConnection();
		}

		boolean flag = false;

		try {
			pst = con.prepareStatement(
					"insert into owners(user_id,owner_name,owner_address,owner_contact) values (?,?,?,?)");
			pst.setInt(1, ownerBean.getUserId());
			pst.setString(2, ownerBean.getoName());
			pst.setString(3, ownerBean.getoAddress());
			pst.setString(4, ownerBean.getoContact());
			int count = pst.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
	
	public static List<OwnerBean> getAllOwners() {
		List<OwnerBean> ownbeans = new ArrayList<>();
		
		if(con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("select * from owners");
			rs = pst.executeQuery();
	
			while(rs.next()) {
				OwnerBean ownerBean = new OwnerBean();
				ownerBean.setoId(1);
				ownerBean.setUserId(rs.getInt(2));
				ownerBean.setoName(rs.getString(3));
				ownerBean.setoAddress(rs.getString(4));
				ownerBean.setoContact(rs.getString(5));
				ownbeans.add(ownerBean);		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ownbeans;
	}
	
	public static OwnerBean getOwnerById(int oid) {
		OwnerBean ownerBean = new OwnerBean();
		if(con == null) {
			getConnection();
		}
		
		try {
			pst = con.prepareStatement("select * from owners where owner_id = ?");
			pst.setInt(1, oid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				ownerBean.setoId(rs.getInt(1));
				ownerBean.setUserId(rs.getInt(2));
				ownerBean.setoName(rs.getString(3));
				ownerBean.setoAddress(rs.getString(4));
				ownerBean.setoContact(rs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ownerBean;
	}
	
	
	public static boolean updateOwner(OwnerBean ownerBean) {
		if(con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("update owners set owner_name = ? ,owner_address = ? ,owner_contact = ? where owner_id = ?");
			pst.setString(1,ownerBean.getoName());
			pst.setString(2, ownerBean.getoAddress());
			pst.setString(3, ownerBean.getoContact());
			pst.setInt(4, ownerBean.getoId());
			int count =pst.executeUpdate();
			if(count > 0) return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
