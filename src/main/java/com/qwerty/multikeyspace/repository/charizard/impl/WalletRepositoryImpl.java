package com.qwerty.multikeyspace.repository.charizard.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Update;
import com.qwerty.multikeyspace.entity.Wallet;
import com.qwerty.multikeyspace.repository.charizard.WalletRepositoryCustom;

public class WalletRepositoryImpl implements WalletRepositoryCustom {

	@Autowired
	@Qualifier("keyspaceCharizardCassandraTemplate")
	CassandraOperations cassandraOperations;

	@Override
	public boolean update(Wallet wallet) {

		Update update = QueryBuilder.update("wallet");
		update.with(QueryBuilder.set("amount", wallet.getAmount()));
		update.where(QueryBuilder.eq("id", wallet.getId()));

		return cassandraOperations.getCqlOperations().execute(update);
	}

}
