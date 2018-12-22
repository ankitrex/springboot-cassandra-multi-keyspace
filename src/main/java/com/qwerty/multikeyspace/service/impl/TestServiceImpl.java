package com.qwerty.multikeyspace.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qwerty.multikeyspace.entity.User;
import com.qwerty.multikeyspace.entity.Wallet;
import com.qwerty.multikeyspace.repository.charizard.WalletRepository;
import com.qwerty.multikeyspace.repository.pikachu.UsersRepository;
import com.qwerty.multikeyspace.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	UsersRepository	userFlowRepository;

	@Autowired
	WalletRepository	walletRepository;

	@Override
	public List<User> fetchAllUsers() {

		return userFlowRepository.findAll();
	}

	@Override
	public List<Wallet> fetchAllTransactions() {

		return walletRepository.findAll();
	}

	@Override
	public Boolean updateTransaction(Wallet wallet) {

		return walletRepository.update(wallet);
	}

}
