package com.election.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.election.beans.UserBean;

public class UserDao {

	static Connection con = null;
	static PreparedStatement pst = null;
	static ResultSet rs = null;

	public static Connection getConnection() {
		DBDAO.connect();
		con = DBDAO.getDbCon();
		return con;
	}

	public static UserBean checkLogin(UserBean userBean) {

		UserBean loginBean = new UserBean();
		if (con == null) {
			getConnection();
		}
		try {
			pst = con.prepareStatement("SELECT user_id,user_name, user_role FROM users WHERE user_name=? AND user_password=?");

			pst.setString(1, userBean.getUserName());
			pst.setString(2, userBean.getUserPassword());
			rs = pst.executeQuery();

			while (rs.next()) {
				loginBean.setUserId(rs.getInt(1));
				loginBean.setUserName(rs.getString(2));
				loginBean.setUserRole(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginBean;
	}

	public static boolean insertUser(UserBean userBean) {
		if (con == null) {
			getConnection();
		}
		boolean insertUser = false;

		try {
			pst = con.prepareStatement("insert into users(user_name,user_password,user_role) values (?,?,?)");
			pst.setString(1, userBean.getUserName());
			pst.setString(2, userBean.getUserPassword());
			pst.setString(3, userBean.getUserRole());
			int count = pst.executeUpdate();
			if (count > 0) {
				insertUser = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insertUser;
	}
	
	public static UserBean getUserById(int uId) {
		if(con == null) {
			getConnection();
		}
		UserBean userBeansReturn = new UserBean();
		try {
			pst = con.prepareStatement("select * from users where user_id = ?");
			pst.setInt(1, uId);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				userBeansReturn.setUserId(rs.getInt(1));
				userBeansReturn.setUserName(rs.getString(2));
				userBeansReturn.setUserPassword(rs.getString(3));
				userBeansReturn.setUserRole(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userBeansReturn;
	}

	public static List<UserBean> getAllUsers() {

		List<UserBean> currentUsers = new ArrayList<>();
		if (con == null) {
			getConnection();
		}

		try {
			pst = con.prepareStatement("select * from users");
			rs = pst.executeQuery();

			while (rs.next()) {
				UserBean userBeans = new UserBean();
				userBeans.setUserId(rs.getInt(1));
				userBeans.setUserName(rs.getString(2));
				userBeans.setUserPassword(rs.getString(3));
				userBeans.setUserRole(rs.getString(4));
				currentUsers.add(userBeans);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentUsers;

	}
	
	public static boolean UpdateUser(UserBean userBean) {
		if (con == null) {
			getConnection();
		}
		boolean flag = false;
		try {
			pst = con.prepareStatement("update users set user_name = ? ,user_password = ?,user_role = ? where user_id = ?");
			pst.setString(1, userBean.getUserName());
			pst.setString(2, userBean.getUserPassword());
			pst.setString(3,userBean.getUserRole());
			pst.setInt(4, userBean.getUserId());
			int count = pst.executeUpdate();
			
			if(count > 0) flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}