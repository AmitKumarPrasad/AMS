package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository repository;
	
	public Account findById(Long id) {
		return repository.getOne(id);
	}
	
	public List<Account> getAll(){
		return repository.findAll();
	}
	
	public void create(Account account) {
		repository.save(account);
	}
	
	public void update(Long id) {
		repository.getOne(id);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
