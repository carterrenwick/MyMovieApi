package com.mymovie.util;

import java.sql.Connection;
import java.sql.DriverManager;

public final class H2DbUtil {

	// DB credentials should always be stored in a secure location
	private static final String JDBC_DRIVER = "org.h2.Driver";
	private static final String DB_URL = "jdbc:h2:tcp://localhost/~/test"; // "jdbc:h2:~/test"
	private static final String USER = "CTADMIN";
	private static final String PASS = "verysecurepassphrase";

	public static Connection getDbConn() {
		Connection conn = null;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
