package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.DriverBean;

public class DriverDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}

	public static boolean updateStatus(int id) {

		try {
			pst = con.prepareStatement("update drivers set driver_status = ? where driver_id = ?");
			pst.setString(1, "Approved");
			pst.setInt(2, id);
			int count = pst.executeUpdate();
			if (count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<DriverBean> getAllDrivers() {
		List<DriverBean> listofReqDrivers = new ArrayList<>();
		if (con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("select * from drivers where driver_status = ?");
			pst.setString(1, "Approved");
			rs = pst.executeQuery();

			while (rs.next()) {
				DriverBean driverBeans = new DriverBean();
				driverBeans.setDriverId(rs.getInt(1));
				driverBeans.setOwnerId(rs.getInt(2));
				driverBeans.setDriverName(rs.getString(3));
				driverBeans.setDriverContact(rs.getString(4));
				driverBeans.setDriverStatus(rs.getString(5));
				listofReqDrivers.add(driverBeans);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listofReqDrivers;
	}
	

}
