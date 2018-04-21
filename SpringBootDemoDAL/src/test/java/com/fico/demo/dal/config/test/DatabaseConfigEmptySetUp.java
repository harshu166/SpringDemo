package com.fico.demo.dal.config.test;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import com.fico.data.ds.HikariDataSourceFactory;
import com.zaxxer.hikari.HikariDataSource;

@ComponentScan(basePackages = { "com.fico.demo.dal.dao", "com.fico.demo.dal.config", "com.fico.demo.dal.config" })
public class DatabaseConfigEmptySetUp {
	private static final Logger log = LoggerFactory.getLogger(DatabaseConfigEmptySetUp.class);
	private static HikariDataSource ds = HikariDataSourceFactory.getTransactional();
	private static Connection conn;

	public DatabaseConfigEmptySetUp() {
		super();
		try {
			conn = ds.getConnection();
			log.debug("Got db connection");
		} catch (SQLException e) {
			log.error("Error getting db connection");
		}
		
		executeDMLs(conn);
		closeConnection(conn);
				
	}
	

	public static void executeDMLs(Connection conn) {
		try {

			ScriptUtils.executeSqlScript(conn,
					new EncodedResource(new ClassPathResource("sql/delete_data.sql"), StandardCharsets.UTF_8));
			log.info("Executed 'insert_data.sql'");
		} catch (ScriptStatementFailedException e) {
			log.error("Error executing script 'sql/delete_data.sql'");
		}

	}
	
	public static void closeConnection(Connection conn) {
		if (null != conn) {
			try {				
				conn.close();
				log.debug("Database connection closed");
			} catch (SQLException e) {
				log.error("Error closing database connection");
			}
		}
	}

}
