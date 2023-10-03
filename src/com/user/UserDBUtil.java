package com.user;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDBUtil {
	
	public static List<User> validate(String username, String password){
	
	ArrayList<User> user = new ArrayList<>();
	
	//create database connection
	
	String url = "jdbc:mysql://localhost:3306/onlinemusicstore";
	String userDB = "root";
	String passwordDB = "Dxsuni2003@#";
	
	
	//validate
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, userDB, passwordDB);
		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM user WHERE Username = '"+username+"' AND Password = '"+password+"'";
		ResultSet result = stmt.executeQuery(sql);
		
		if(result.next()) {
			
			int id = result.getInt(1);
			String firstname = result.getString(2);
			String lastname = result.getNString(3);
			String email = result.getString(4);
			String usernameU = result.getString(5);
			String passwordU = result.getString(6);
			
			
			User u = new User(id, firstname, lastname, email, usernameU, passwordU);
			
			user.add(u);
			
			
		}
		
	}
	
	catch(Exception e){
		
		e.printStackTrace();
			
	}
	
	return user;
	
	

}
}
