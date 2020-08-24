package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnex {
	private static Connection connex;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2","root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnex() {
		return connex;
	}
}
