package com.wedemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webdemo.models.User;

public class UserDaolmpl {
	
	Connection con = null ;
	
	public void signup(User u){
		
		con = DB.getDbcon();
		
		String sql = "insert into user(fname, lname, username, password) values(?, ?, ?, ?)" ;
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql) ;
				pstm.setString(1,  u.getFnmae());
				pstm.setString(2,  u.getLname());
				pstm.setString(3,  u.getUsername());
				pstm.setString(4,  u.getPassword());
				
				pstm.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String userLogin(String un, String psw){
		
		User u = new User();
		
		
		
		con = DB.getDbcon() ;
		
		String sql = "select *from user where username='"+un+"' and password = '"+psw+"'" ;
		
		try {
			Statement stm = con.createStatement() ;
			ResultSet rs = stm.executeQuery(sql) ;
			
			if(rs.next()){
				
				return rs.getString("fname");
				
				//u.setFnmae(rs.getString("fname"));
				//u.setLnmae(rs.getString("fname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
	public List<User> getAllUser(){
		
		con = DB.getDbcon();
		
		List<User> ulist = new ArrayList<User>() ;
		String sql = "select *from user" ;
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql) ;
			
			while(rs.next()){
				
				User u = new User() ;
				
				u.setId(rs.getInt("id"));
				u.setFnmae(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				
				ulist.add(u) ;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ulist ;
	}

}
