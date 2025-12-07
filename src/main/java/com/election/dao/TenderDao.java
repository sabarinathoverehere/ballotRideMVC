package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.TenderBean;

public class TenderDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}

	// create
	public static boolean insertTender(TenderBean tenderBean) {
		if (con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("insert into tenders(location_id,tender_distance) values (?,?)");
			pst.setInt(1, tenderBean.getLocationId());
			pst.setInt(2, tenderBean.getTenderDistance());
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// read
	public static List<TenderBean> getAllTenders() {
		if (con == null) {
			getConnection();
		}
		List<TenderBean> tenders = new ArrayList<>();

		try {
			pst = con.prepareStatement("select * from tenders");
			rs = pst.executeQuery();

			while (rs.next()) {
				TenderBean tenderBean = new TenderBean();
				tenderBean.setTenderId(rs.getInt("tender_id"));
				tenderBean.setLocationId(rs.getInt("location_id"));
				tenderBean.setTenderDistance(rs.getInt("tender_distance"));
				tenderBean.setTenderStatus(rs.getString("tender_status"));
				tenderBean.setTenderCreation(rs.getTimestamp("tender_creation"));
				tenderBean.setTenderClosed(rs.getTimestamp("tender_closed"));
				tenders.add(tenderBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenders;
	}
	
	//readopentenders
	public static List<TenderBean> getOpenTenders() {
		if (con == null) {
			getConnection();
		}
		List<TenderBean> tenders = new ArrayList<>();

		try {
			pst = con.prepareStatement("select * from tenders where tender_status = ? or tender_status = ?");
			pst.setString(1, "open");
			pst.setString(2, "active");
			
			rs = pst.executeQuery();

			while (rs.next()) {
				TenderBean tenderBean = new TenderBean();
				tenderBean.setTenderId(rs.getInt("tender_id"));
				tenderBean.setLocationId(rs.getInt("location_id"));
				tenderBean.setTenderDistance(rs.getInt("tender_distance"));
				tenderBean.setTenderStatus(rs.getString("tender_status"));
				tenderBean.setTenderCreation(rs.getTimestamp("tender_creation"));
				tenderBean.setTenderClosed(rs.getTimestamp("tender_closed"));
				tenders.add(tenderBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenders;
	}
	
	//updatestatus
	public static boolean updateStatus(int tid) {
		if (con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("update tenders set tender_status = ? where tender_id = ?");
			pst.setString(1, "active");
			pst.setInt(2, tid);
			
			return pst.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
