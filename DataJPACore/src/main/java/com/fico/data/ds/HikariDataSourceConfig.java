package com.fico.data.ds;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheck;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.fico.data.util.LoadConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author harishagarwal
 * The class HikariDataSourceConfig
 *
 */
public class HikariDataSourceConfig {
	private static final Logger log = LoggerFactory.getLogger(HikariDataSourceConfig.class);

	private static HikariConfig config = new HikariConfig();
	private static HikariDataSource ds;
	private static Properties configProperties;
	private static final String initSQL = "select current_timestamp() from dual";

	private HikariDataSourceConfig() {
	}

	public static HikariDataSource getDataSource(String dsPoolName, MetricRegistry metricRegistry,
			HealthCheckRegistry healthCheckRegistry
	        ) {
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
		config.setPoolName(dsPoolName);
		config.setMaximumPoolSize(10);
		config.setMinimumIdle(2);
		config.setJdbcUrl("jdbc:mysql://localhost:3306/world");
		config.setUsername("admin");
		config.setPassword("mysql");
		config.setConnectionInitSql(initSQL);
		config.setLeakDetectionThreshold(5000);
	

		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "256");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("useServerPrepStmts", "true");
				
		// Add HealthCheck
		config.setHealthCheckRegistry(healthCheckRegistry);
		// Add Metrics
		config.setMetricRegistry(metricRegistry);		
		ds = new HikariDataSource(config);
		
		return ds;
	}
}