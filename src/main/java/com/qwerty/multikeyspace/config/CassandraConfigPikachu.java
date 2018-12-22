package com.qwerty.multikeyspace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.qwerty.multikeyspace.repository.pikachu", cassandraTemplateRef = "keyspacePikachuCassandraTemplate")
public class CassandraConfigPikachu {

	@Autowired
	CassandraConfig	cassandraConfig;

	@Value("${cassandra.keyspace.keyspacePikachuCassandraTemplate}")
	private String	keyspace;

	@Bean("keyspacePikachuSession")
	public CassandraSessionFactoryBean session() {

		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cassandraConfig.cluster().getObject());
		session.setKeyspaceName(keyspace);
		session.setConverter(cassandraConfig.converter());
		session.setSchemaAction(SchemaAction.NONE);

		return session;
	}

	@Bean("keyspacePikachuCassandraTemplate")
	public CassandraTemplate cassandraTemplate() {

		return new CassandraTemplate(session().getObject());
	}
}
