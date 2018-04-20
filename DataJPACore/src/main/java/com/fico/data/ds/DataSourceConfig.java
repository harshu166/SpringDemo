package com.fico.data.ds;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fico.data.util.LoadConfig;

/**
 * @author harishagarwal
 * The class DataSourceConfig
 *
 */
public class DataSourceConfig {
	private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

	private static BasicDataSource ds;
	private static Properties configProperties;
	
	private DataSourceConfig() {
	}

	public static DataSource getDataSource() {
		try {
			// Below code shows sample to load data source properties
			// from classpath available file. 
			configProperties = LoadConfig.getConfigProp();
			//log.info(
				//	"Sample reading from config.properties, jdbcURL:" + configProperties.getProperty("jdbcURL"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// below is the data source properties setting here.
		// The certain properties can be configured via UI and read from database instead
		ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/world");
		ds.setUsername("admin");
		ds.setPassword("mysql");
		ds.setDefaultAutoCommit(true);
		ds.setInitialSize(10);
		ds.setMaxIdle(2);
		ds.setPoolPreparedStatements(true);
		
		return ds;
	}
}