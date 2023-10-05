package com.user;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet result = null;
	
	
	
	public static List<User> validate(String username, String password){
	
	ArrayList<User> user = new ArrayList<>();
	
	
	
	
	//validate
	try {
		
		con = DBConnection.getConnection();
		stmt = con.createStatement();
		String sql = "SELECT * FROM user WHERE Username = '"+username+"' AND Password = '"+password+"'";
		result = stmt.executeQuery(sql);
		
		if(result.next()) {
			
			int id = result.getInt(1);
			String firstname = result.getString(2);
			String lastname = result.getNString(3);
			String email = result.getString(4);
			String usernameU = result.getString(5);
			String passwordU = result.getString(6);
			//String userRole = result.getString(7);
			
			User u = new User(id, firstname, lastname, email, usernameU, passwordU);
			
			user.add(u);
			
			
		}
		
	}
	
	catch(Exception e){
		
		e.printStackTrace();
			
	}
	
	return user;
}
	
	public static boolean insertUser(String firstname, String lastname, String email, String username, String password) {
		
		boolean isSuccess = false;
			
		try {
			
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "INSERT INTO user VALUES (0, '"+firstname+"', '"+lastname+"', '"+email+"', '"+username+"', '"+password+"') ";
			int result = stmt.executeUpdate(sql);
			
			
			if(result > 0) {
				
				isSuccess = true;	
			}
			
			else {
				isSuccess = false;
				
			}
			
			
			
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
		
	}
	
	
}
