package com.qwerty.multikeyspace.repository.charizard;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.qwerty.multikeyspace.entity.Wallet;

public interface WalletRepository extends CassandraRepository<Wallet, String>, WalletRepositoryCustom {

}
