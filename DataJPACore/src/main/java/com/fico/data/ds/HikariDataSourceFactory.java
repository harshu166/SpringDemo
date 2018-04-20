package com.fico.data.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author harishagarwal
 *
 */
public class HikariDataSourceFactory {
	
	private static final Logger log = LoggerFactory.getLogger(HikariDataSourceFactory.class);
	private static MetricRegistry metricRegistry = new MetricRegistry();
	private static HealthCheckRegistry healthCheckRegistry = new HealthCheckRegistry();
		
	/*
	 * This pool is made for short quick transactions that the web application uses.
	 * Using enum singleton pattern for lazy singletons
	 */
	private enum Transactional {
				
		INSTANCE(HikariDataSourceConfig.getDataSource("TRANSConnPool", metricRegistry, healthCheckRegistry));
		private final HikariDataSource dataSource;

		private Transactional(HikariDataSource dataSource) {
			this.dataSource = dataSource;
		}

		public HikariDataSource getDataSource() {
			return dataSource;
		}
	}

	public static HikariDataSource getTransactional() {		
		return Transactional.INSTANCE.getDataSource();
	}
	
	/*
     *  This pool is designed for longer running transactions / bulk inserts / background jobs
     *  Basically if you have any multithreading or long running background jobs
     *  you do not want to starve the main applications connection pool.
     *
     *  EX.
     *  You have an endpoint that needs to insert 1000 db records
     *  This will queue up all the connections in the pool
     *
     *  While this is happening a user tries to log into the site.
     *  If you use the same pool they may be blocked until the bulk insert is done
     *  By splitting pools you can give transactional queries a much higher chance to
     *  run while the other pool is backed up.
     */
    private enum Processing {
    	INSTANCE(HikariDataSourceConfig.getDataSource("PROCConnPool", metricRegistry, healthCheckRegistry));
        private final HikariDataSource dataSource;
        private Processing(HikariDataSource dataSource) {
            this.dataSource = dataSource;
        }
        public HikariDataSource getDataSource() {
            return dataSource;
        }
    }

    public static HikariDataSource getProcessing() {
        return Processing.INSTANCE.getDataSource();
    }
    
    public static void main(String[] args) {
        HikariDataSourceFactory.getProcessing();
        HikariDataSourceFactory.getTransactional();
        
        log.info("!!!Test run complete!!!");
    }
}
