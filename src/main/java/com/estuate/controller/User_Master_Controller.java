package com.estuate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.Exception.BusinessException;
import com.estuate.Exception.ControllerException;
import com.estuate.entity.User_Master;
import com.estuate.service.User_Master_Service_Interface;

@RestController
@RequestMapping("/user")
public class User_Master_Controller {
@Autowired
User_Master_Service_Interface service;
@PostMapping("/add")
public ResponseEntity<?> saveUser( @RequestBody User_Master user)
{try {
	User_Master addUserMaster= service.addUser(user);
	return new ResponseEntity<User_Master>(addUserMaster, HttpStatus.OK) ;}
catch (BusinessException e) {
	ControllerException ce = new ControllerException("User_Master_Controller-adddateUserMaster","Business Exception");
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
} catch (Exception e) {
	ControllerException ce = new ControllerException("User_Master_Controller-addUserMaster","Something went wrong on Controller");
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
}

}
@PutMapping("/update/{id}")
public ResponseEntity<?> updateUser( @PathVariable("id") Long id,@RequestBody User_Master user)
{
	try{User_Master updateUser= service.updateUser(id,user);
	return new ResponseEntity<User_Master>(updateUser, HttpStatus.OK) ;}
	catch (BusinessException e) {
		ControllerException ce = new ControllerException("User_Master_Controller-UpdateUserMaster","Business Exception");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	} catch (Exception e) {
		ControllerException ce = new ControllerException("User_Master_Controller-UpdateUserMaster","Something went wrong on Controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}

	}
@GetMapping("/listofUsers")
public ResponseEntity<List<User_Master>> listofUsers(){
	List<User_Master>  AllUsers=service.listOf_Users();
	return new ResponseEntity<List<User_Master>>(AllUsers, HttpStatus.OK) ;
	
}
@DeleteMapping("/delete/{id}")
public   ResponseEntity<?>  deleteUser(@PathVariable("id") Long id) {
	try{
		User_Master deleteUserMaster= service.deleteUser(id);
	return new ResponseEntity<String>("User Id is Successfully Deleted From the data Base   Deleted Details = "+deleteUserMaster,HttpStatus.ACCEPTED) ;
} catch (BusinessException e) {
	ControllerException ce = new ControllerException("User_Master_Controller-deleteUser","Business Exception");
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
} catch (Exception e) {
	ControllerException ce = new ControllerException("User_Master_Controller-deleteUser","Something went wrong on Controller");
	return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
}}


@GetMapping("/userById/{id}")
public ResponseEntity<?> getUserById(@PathVariable("id") Long id){		
	try {
		User_Master getById= service.getbyid_User(id);
		return new ResponseEntity<User_Master>(getById, HttpStatus.OK) ;
	} catch (BusinessException e) {
		ControllerException ce = new ControllerException("User_Master_Controller-getUserById","Business Exception");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	} catch (Exception e) {
		ControllerException ce = new ControllerException("User_Master_Controller-getUserById","Something went wrong on Controller");
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
	}

}

}
