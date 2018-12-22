package com.qwerty.multikeyspace.repository.pikachu;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.qwerty.multikeyspace.entity.User;

public interface UsersRepository extends CassandraRepository<User, String> {

}
