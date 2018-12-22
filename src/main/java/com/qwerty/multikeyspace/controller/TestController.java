package com.qwerty.multikeyspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qwerty.multikeyspace.entity.User;
import com.qwerty.multikeyspace.entity.Wallet;
import com.qwerty.multikeyspace.service.TestService;

@RestController
public class TestController {

	@Autowired
	TestService testService;

	@GetMapping("/users")
	public List<User> getAllUsers() {

		return testService.fetchAllUsers();
	}

	@GetMapping("/transactions")
	public List<Wallet> getAllTransactions() {

		return testService.fetchAllTransactions();
	}
}
