package com.qwerty.multikeyspace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfig {

	@Value("${cassandra.contact-points}")
	private String	contactPoints;

	@Value("${cassandra.port}")
	private Integer	port;

	@Value("${cassandra.username}")
	private String	username;

	@Value("${cassandra.password}")
	private String	password;

	@Bean
	public CassandraClusterFactoryBean cluster() {

		CassandraClusterFactoryBean cassandraClusterFactoryBean = new CassandraClusterFactoryBean();
		cassandraClusterFactoryBean.setContactPoints(contactPoints);
		cassandraClusterFactoryBean.setPort(port);
		cassandraClusterFactoryBean.setUsername(username);
		cassandraClusterFactoryBean.setPassword(password);
		cassandraClusterFactoryBean.setJmxReportingEnabled(false);

		return cassandraClusterFactoryBean;
	}

	public CassandraMappingContext mappingContext() {

		return new CassandraMappingContext();
	}

	public CassandraConverter converter() {

		return new MappingCassandraConverter(mappingContext());
	}
}
