package com.estuate.service;

import java.util.List;

import com.estuate.entity.User_Master;

public interface User_Master_Service_Interface {
	User_Master addUser(User_Master usermaster);
	User_Master updateUser(Long id,User_Master usermaster);
	List<User_Master> listOf_Users();
	User_Master deleteUser(Long id);
	User_Master getbyid_User(Long id);
}
