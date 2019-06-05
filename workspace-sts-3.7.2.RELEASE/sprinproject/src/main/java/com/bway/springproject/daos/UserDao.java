package com.bway.springproject.daos;

import com.bway.springproject.model.User;

public interface UserDao {
	
	public void signup(User u);
	
	public boolean login(String un, String psw);

}
