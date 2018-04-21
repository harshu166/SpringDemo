package com.fico.data.ds;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author harishagarwal
 *
 */
public class DataSourceFactory {
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceFactory.class);
	private static String poolName = "";
		
	/*
	 * This pool is made for short quick transactions that the web application uses.
	 * Using enum singleton pattern for lazy singletons
	 */
	private enum Transactional {
				
		INSTANCE(DataSourceConfig.getDataSource());
		private final DataSource dataSource;

		private Transactional(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		public DataSource getDataSource() {
			poolName = "TRANConnPool";
			return dataSource;
		}
	}

	public static DataSource getTransactional() {		
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
    	INSTANCE(DataSourceConfig.getDataSource());
        private final DataSource dataSource;
        private Processing(DataSource dataSource) {
            this.dataSource = dataSource;
        }
        public DataSource getDataSource() {
        	poolName = "PROCConnPool";
            return dataSource;
        }
    }

    public static DataSource getProcessing() {
        return Processing.INSTANCE.getDataSource();
    }
    
    public static void main(String[] args) {
    	log.info("Starting unit test");
        try {
        	log.info("Got connection from [PROCConnPool] - " + DataSourceFactory.getProcessing().getConnection());
        	log.info("Got connection from [TRANConnPool] -" + DataSourceFactory.getTransactional().getConnection());
        }
        catch(SQLException e) {
        	
        }
                        
        log.info("!!!Test run complete!!!");
    }
}
