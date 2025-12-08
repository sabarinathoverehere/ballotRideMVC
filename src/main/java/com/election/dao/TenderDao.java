package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.TenderAssignmentViewBean;
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
	
	public static boolean updateStatus(int tid,int oid,int driverId) {
		if (con == null) {
			getConnection();
		}
		try {
			
			pst = con.prepareStatement("insert into tender_assignments(tender_id,owner_id,driver_id) values (?,?,?)");
			pst.setInt(1, tid);
			pst.setInt(2, oid);
			pst.setInt(3, driverId);
			pst.executeUpdate();
			pst.close();
			
			pst = con.prepareStatement("update tenders set tender_status = ? where tender_id = ?");
			pst.setString(1, "active");
			pst.setInt(2, tid);
			
			
			return pst.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//getcurrentstats
	
	public static List<TenderAssignmentViewBean> getAllAssignedTenders() {
	    List<TenderAssignmentViewBean> list = new ArrayList<>();
	    if (con == null) {
	        getConnection();
	    }
	    try {
	       
	    	PreparedStatement pst = con.prepareStatement(
	    	        "SELECT ta.tender_id, ta.owner_id, ta.driver_id, ta.assigned_at, ta.completed_at, "
	    	      + "t.tender_status, t.tender_creation "
	    	      + "FROM tender_assignments AS ta "
	    	      + "JOIN tenders AS t ON ta.tender_id = t.tender_id "
	    	      + "ORDER BY ta.assigned_at DESC");

	    	ResultSet rs = pst.executeQuery();

	    	while (rs.next()) {
	    	    TenderAssignmentViewBean bean = new TenderAssignmentViewBean();
	    	    bean.setTenderId(rs.getInt(1));
	    	    bean.setOwnerId(rs.getInt(2));
	    	    bean.setDriverId(rs.getInt(3));
	    	    bean.setAssignedAt(rs.getTimestamp(4));
	    	    bean.setTenderClosed(rs.getTimestamp(5));     // FIXED
	    	    bean.setTenderStatus(rs.getString(6));       // FIXED
	    	    bean.setTenderCreation(rs.getTimestamp(7));  // FIXED

	    	    list.add(bean);
	    	

	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	
	public static boolean closeTender(int id) {
		if(con == null) {
			getConnection();
		}
		try {
				//First update tender_assignments.completed_at 
			
			    PreparedStatement pst = con.prepareStatement("update tender_assignments SET completed_at = NOW() WHERE tender_id = ?");
		        pst.setInt(1, id);
		        int rowsOne = pst.executeUpdate(); 
		        pst.close();
		        
		        //Then update tenders.tender_status and tender_closed
		        
		        PreparedStatement pst2 = con.prepareStatement("update tenders set tender_status = ? ,tender_closed = NOW() where tender_id = ?");
		        pst2.setString(1, "closed");
		        
		        pst2.setInt(2, id);
		        int rowsTwo = pst2.executeUpdate();
		        pst2.close();
		        
		        if(rowsOne >0 && rowsTwo > 0) return true;
		        
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
