package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private AccountService service;
	
	@GetMapping("/ac/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id){
		return new ResponseEntity<Account>(service.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Account>> getAccounts(){
		return new ResponseEntity<List<Account>>(service.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/createAccount")
	public ResponseEntity<String>createAccount(@Valid@RequestBody Account account){
		service.create(account);
		return new ResponseEntity<String>("Account Created Successfully",HttpStatus.CREATED);
	}
	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<String>updateAccount(@PathVariable Long id,@RequestBody Account account){
		if(service.findById(id)==null) {
			return new ResponseEntity<String>("Account not found",HttpStatus.NOT_FOUND);
		}else {
			service.update(id);
		}
		return new ResponseEntity<String>("Account Update Success",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id){
		if(service.findById(id)==null) {
			return new ResponseEntity<String>("Account Not Found",HttpStatus.NOT_FOUND);
		}else {
			service.delete(id);
			return new ResponseEntity<String>("Account Deleted Successfully",HttpStatus.OK);
		}
	}

}
