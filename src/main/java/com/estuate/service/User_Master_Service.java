package com.estuate.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.estuate.Exception.BusinessException;
import com.estuate.entity.User_Master;
import com.estuate.repository.User_Master_Repository;

@Service
public class User_Master_Service implements User_Master_Service_Interface {
	@Autowired
	User_Master_Repository user_Master_Repository;
	@Override
	public User_Master addUser(User_Master usermaster) {
		User_Master addingUser=usermaster;
		if ((user_Master_Repository.findByUserName(addingUser.getUserName())==null )){// user_Master_Repository.findbyemail(addingUser.getEmail())==null)){
			
			try { 
				Date date=new Date();
	            usermaster.setCreated_Date(date.toString());
	            addingUser= user_Master_Repository.save(usermaster);
	            return addingUser;
	            }
			catch (IllegalArgumentException e) {
				throw new BusinessException("User_Master_Service-AddUser",
						"Not Valid Name, Please Enter Valid Name " + e.getMessage());
			} catch (Exception e) {
				throw new BusinessException("User_Master_Service-AddUser",
						"Something went wrong in service layer " + e.getMessage());
			}
		}
		else {
			throw new BusinessException("User_Master_Service-AddUser",
					"Email Id or UserName Already Exsists in DataBase ")	;
		}
		
	}
			
	@Override
	public User_Master updateUser(Long id,User_Master usermaster) {
		if(!user_Master_Repository.existsById(id)) {
			throw new BusinessException("User_Master_Service-Modify Group By ID",
					" Group ID Not found in DataBase, Please enter valid ID");
		}
		User_Master existingUser=user_Master_Repository.findById(id).orElseThrow(()-> new BusinessException("User ID is not present in Database", "Please Enter valid ID"));
		 Date date=new Date();
		 existingUser.setUpdated_Date(date.toString());
		 existingUser.setEmail(usermaster.getEmail());
		 existingUser.setRolemaster(usermaster.getRolemaster());
		  user_Master_Repository.save(existingUser);
		
		return existingUser;
	}
	@Override
	public List<User_Master> listOf_Users() {
		List<User_Master> listallUsers=null;
		try {
			listallUsers=user_Master_Repository.findAll();
		} catch (Exception e) {
			throw new BusinessException("User_Master_Service-listOf_Users",
					"Something went wrong in service layer while fetching all user details " + e.getMessage());
		}
		if (listallUsers.isEmpty()) {
			throw new BusinessException("User_Master_Service-listOf_Users",
					" List is Empty, Add Some Data in Register Page... ");
		}
		return listallUsers;
	}
	@Override
	public User_Master deleteUser(Long id) {
		if(!user_Master_Repository.existsById(id)) {
			throw new BusinessException("deleteUser User By ID",
					" User ID Not found in DataBase, Please enter valid ID");
		}
		User_Master deleted_user = user_Master_Repository.getById(id);
		try {
		user_Master_Repository.deleteById(id);}
		 catch (NoSuchElementException e) {
				throw new BusinessException("User_Master_Service-deleteUser",
						"User_ID  Not found in DataBase, Please enter valid ID " + e.getMessage());
			} catch (IllegalArgumentException e) {
				throw new BusinessException("User_Master_Service-deleteUser",
						"Something went wrong in service layer " + e.getMessage());
			}
		return deleted_user;
	}
	@Override
	public User_Master getbyid_User(Long id) {
		if (id.equals(null)) {
			throw new BusinessException("User_Master_Service-getbyid_User",
					"You Entered a null value, please Enter Any int Value");
		}
		
		try{
			return user_Master_Repository.findById(id).get();}
		catch (NoSuchElementException e) {
			throw new BusinessException("User_Master_Service-getbyid_User",
					"user ID Not found in DataBase, Please enter valid ID " + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new BusinessException("User_Master_Service-getbyid_User",
					"Something went wrong in service layer " + e.getMessage());
		}

	}

}
