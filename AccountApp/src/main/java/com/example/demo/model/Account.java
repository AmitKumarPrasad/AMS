package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name = "AccountApp")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "account_name")
	private String name;
	@Column(name = "account_email")
	private String email;
	
	public Account() {}
	
	

	public Account(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	

}
