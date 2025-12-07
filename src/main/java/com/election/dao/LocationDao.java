package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.LocationBean;

public class LocationDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {

		DBDAO.connect();
		con=DBDAO.getDbCon();
		return con;

	}

	// insert location
	public static boolean insertLocation(LocationBean locationBean) {

		if (con == null) {
			getConnection();
		}

		try {
			pst = con.prepareStatement("insert into locations(location_name) values (?)");
			pst.setString(1, locationBean.getLocationName());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// get location by id - used in Edit
	public static LocationBean getLocationById(int id) {
		if (con == null) {
			getConnection();
		}
		LocationBean locBean = new LocationBean();
		try {
			pst = con.prepareStatement("select * from locations where location_id = ?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while (rs.next()) {
				locBean.setLocationId(rs.getInt("location_id"));
				locBean.setLocationName(rs.getString("location_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locBean;
	}

	//fetch all Locations
	public static List<LocationBean> getAllLocations() {
		List<LocationBean> locationBeans = new ArrayList<>();

		if (con == null) {
			getConnection();
		}

		try {
			pst = con.prepareStatement("select * from locations");
			rs = pst.executeQuery();
			while (rs.next()) {
				LocationBean locBean = new LocationBean();
				locBean.setLocationId(rs.getInt(1));
				locBean.setLocationName(rs.getString(2));
				locationBeans.add(locBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return locationBeans;

	}
	
	//update 
	public static boolean updateLocation(LocationBean locBean) {
		if(con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("update locations set location_name = ?  where location_id = ?");
			pst.setString(1,locBean.getLocationName());
			pst.setInt(2, locBean.getLocationId());
			
			return pst.executeUpdate() > 0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
