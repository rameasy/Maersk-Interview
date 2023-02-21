package com.booking.maersk.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

import java.util.Arrays;
import java.util.List;

/**
 * The Class CassandraConfig.
 */
@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	/** The Constant KEYSPACE. */
	public static final String KEYSPACE = "test_keyspace";

	/**
	 * Gets the schema action.
	 *
	 * @return the schema action
	 */
	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}

	/**
	 * Gets the keyspace creations.
	 *
	 * @return the keyspace creations
	 */
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE);
		return Arrays.asList(specification);
	}

	/**
	 * Gets the keyspace drops.
	 *
	 * @return the keyspace drops
	 */
	@Override
	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
		return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
	}

	/**
	 * Gets the keyspace name.
	 *
	 * @return the keyspace name
	 */
	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}

	/**
	 * Gets the entity base packages.
	 *
	 * @return the entity base packages
	 */
	@Override
	public String[] getEntityBasePackages() {
		return new String[] { "com.booking.maersk.app.model" };
	}
}
