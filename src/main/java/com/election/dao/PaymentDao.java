package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.PaymentBean;

public class PaymentDao {
	
	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;
	
	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}
	
	//create payment 
	
	public static boolean createPaymentTender(int tenderId) {
		if(con == null) {
			getConnection();
		}
		int ownerId =0;
		int distance = 0;
		try {
			pst = con.prepareStatement("select owner_id from tender_assignments where tender_id = ?");
			pst.setInt(1, tenderId);
			rs= pst.executeQuery();
			
			while(rs.next()) {
				ownerId = rs.getInt(1);
			}
			
			pst.close();
			rs.close();
			
			pst = con.prepareStatement("select tender_distance from tenders where tender_id = ?");
			pst.setInt(1, tenderId);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				distance = rs.getInt(1);
			}
			
			pst.close();
			rs.close();
			
			double amount = distance * 10;
			
			pst = con.prepareStatement(
				    "insert into payments(tender_id, owner_id, payment_amount, payment_status) values (?, ?, ?, ?)"
				);
				pst.setInt(1, tenderId);
				pst.setInt(2, ownerId);
				pst.setDouble(3, amount);
				pst.setString(4, "notpaid"); // <-- fix here

			return pst.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static List<PaymentBean> getAllPayemnts() {
		if(con == null) {
			getConnection();
		}
		List<PaymentBean> payments = new ArrayList<>();
		try {
			pst = con.prepareStatement("select * from payments");
			rs=pst.executeQuery();
			
			while(rs.next()) {
				PaymentBean paymentBean = new PaymentBean();
				paymentBean.setPaymentId(rs.getInt(1));
				paymentBean.setTenderId(rs.getInt(2));
				paymentBean.setOwnerId(rs.getInt(3));
				paymentBean.setAmount(rs.getDouble(4));
				paymentBean.setStatus(rs.getString(5));
				
				payments.add(paymentBean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return payments;
	}
	
	// make payments 
	public static boolean makePayment(int payid) {
		if(con == null) {
			getConnection();
		}
		try {
			pst=con.prepareStatement("update payments set payment_status = ? where payment_id = ?");
			pst.setString(1, "paid");
			pst.setInt(2, payid);
			
			return pst.executeUpdate() > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// payments for ownerview
	public static List<PaymentBean> getPaymentsByOwner(int ownerId) {
	    if (con == null) {
	        getConnection();
	    }
	    List<PaymentBean> payments = new ArrayList<>();
	    try {
	        pst = con.prepareStatement("SELECT * FROM payments WHERE owner_id = ?");
	        pst.setInt(1, ownerId);
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            PaymentBean paymentBean = new PaymentBean();
	            paymentBean.setPaymentId(rs.getInt("payment_id"));
	            paymentBean.setTenderId(rs.getInt("tender_id"));
	            paymentBean.setOwnerId(rs.getInt("owner_id"));
	            paymentBean.setAmount(rs.getDouble("payment_amount"));
	            paymentBean.setStatus(rs.getString("payment_status"));
	            payments.add(paymentBean);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return payments;
	}


}
