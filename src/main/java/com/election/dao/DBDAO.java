package com.election.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBDAO {

	private static Connection dbCon;
	private static String dbDriver;
	private static String dburl;
	private static String dbuser;
	private static String dbpassword;

	private static void dbInit() {

		try {
			dbDriver = "com.mysql.cj.jdbc.Driver";
			dburl = "jdbc:mysql://localhost:3306/ballotride";
			dbuser = "root";
			dbpassword = "password";
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void connect() {

		try {
			dbInit();
			Connection con = null;
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dburl,dbuser,dbpassword);
			setDbCon(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDbCon() {
		return dbCon;
	}

	public static void setDbCon(Connection con) {
		dbCon = con;
	}

}
