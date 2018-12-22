package com.qwerty.multikeyspace;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qwerty.multikeyspace.entity.User;
import com.qwerty.multikeyspace.entity.Wallet;
import com.qwerty.multikeyspace.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiKeyspaceApplicationTests {

	@Autowired
	TestService testService;

	@Test
	public void contextLoads() {

		List<User> a = testService.fetchAllUsers();
		a.forEach(System.out::println);

		List<Wallet> b = testService.fetchAllTransactions();
		b.forEach(System.out::println);

		Wallet wallet = new Wallet();
		wallet.setId("3");
		wallet.setAmount(10000);
		testService.updateTransaction(wallet);
	}

}
