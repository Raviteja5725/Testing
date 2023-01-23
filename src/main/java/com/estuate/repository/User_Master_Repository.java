package com.estuate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estuate.entity.User_Master;
@Repository
public interface User_Master_Repository extends JpaRepository<User_Master, Long>{


	User_Master findByUserName(String userName);


	//User_Master findbyemail(String email);

	
	


}
