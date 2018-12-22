package com.qwerty.multikeyspace.service;

import java.util.List;

import com.qwerty.multikeyspace.entity.User;
import com.qwerty.multikeyspace.entity.Wallet;

public interface TestService {

	List<User> fetchAllUsers();

	List<Wallet> fetchAllTransactions();

	Boolean updateTransaction(Wallet wallet);
}
