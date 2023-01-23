package com.estuate.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
 
// Class
public class User_Master {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	
	private String email;
	private  String fullName;
	private String status;
	private String created_Date;
	private String updated_Date;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_master_id",referencedColumnName = "id")
	private List<Role_Master> rolemaster;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getCreated_Date() {
		return created_Date;
	}

	public void setCreated_Date(String created_Date) {
		this.created_Date = created_Date;
	}

	public String getUpdated_Date() {
		return updated_Date;
	}

	public void setUpdated_Date(String updated_Date) {
		this.updated_Date = updated_Date;
	}

	public List<Role_Master> getRolemaster() {
		return rolemaster;
	}

	public void setRolemaster(List<Role_Master> rolemaster) {
		this.rolemaster = rolemaster;
	}
	
	
}