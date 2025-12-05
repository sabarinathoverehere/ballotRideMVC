package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.OwnerBean;
import com.election.beans.VehicleBean;

public class VehicleDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}

	// add 

	public static boolean vehicleInsert(VehicleBean vehicleBean) {
		
		if(con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("insert into vehicle(owner_id,vehicle_number,vehicle_type) values (?,?,?)");
			pst.setInt(1, vehicleBean.getOwnerId());
			pst.setString(2, vehicleBean.getVehicleNo());
			pst.setString(3, vehicleBean.getVehicleType());
			int count = pst.executeUpdate();
			if (count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Read
	
	public static List<VehicleBean> getAllVehicles() {
		
		if(con == null) {
			getConnection();
		}
		List<VehicleBean> allVehicles = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from vehicle");
			rs = pst.executeQuery();
			
			while(rs.next()) {
				VehicleBean vehicleBeans = new  VehicleBean();
				vehicleBeans.setOwnerId(rs.getInt("owner_id"));
				vehicleBeans.setVehicleNo(rs.getString("vehicle_number"));
				vehicleBeans.setVehicleType(rs.getString("vehicle_type"));
				allVehicles.add(vehicleBeans);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allVehicles;
	}
	
	public static VehicleBean getVehicleById(int vid) {
		VehicleBean vehicleBean = new VehicleBean();
		if(con == null) {
			getConnection();
		}
		
		try {
			pst = con.prepareStatement("select * from vehicle where vehicle_id = ?");
			pst.setInt(1, vid);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				vehicleBean.setVehicleId(vid);
				vehicleBean.setOwnerId(rs.getInt("owner_id"));
				vehicleBean.setVehicleNo(rs.getString("vehicle_number"));
				vehicleBean.setVehicleType(rs.getString("vehicle_type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vehicleBean;
	}
	
	public static boolean updateVehicle(VehicleBean vehicleBean) {
		if(con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("update vehicle set owner_id = ? ,vehicle_number = ? ,vehicle_type = ? where vehicle_id = ?");
			pst.setInt(1,vehicleBean.getOwnerId());
			pst.setString(2, vehicleBean.getVehicleNo());
			pst.setString(3, vehicleBean.getVehicleType());
			pst.setInt(4,vehicleBean.getVehicleId());
			int count =pst.executeUpdate();
			if(count > 0) return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
	

}
