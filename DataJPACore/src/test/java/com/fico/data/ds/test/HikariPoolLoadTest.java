package com.fico.data.ds.test;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;
import com.fico.data.ds.HikariDataSourceFactory;

public class HikariPoolLoadTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(HikariPoolLoadTest.class);

	private static MetricRegistry metricRegistry = new MetricRegistry();
	
	private static int MAX_ITERATIONS = 1000;
	private static Slf4jReporter logReporter = Slf4jReporter.forRegistry(metricRegistry).outputTo(LOGGER).build();
	private static ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry)
			.convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build();
	
	private static Timer timer = new Timer();
	

	public static void main(String[] args) {

		HikariPoolLoadTest.init();
		HikariPoolLoadTest.testOpenCloseConnections();

	}

	public static DataSource getDataSource() {
		return HikariDataSourceFactory.getTransactional();
	}

	public static void init() {
		timer = metricRegistry.timer("Hikary DataSource Connection Pool");
		consoleReporter.start(1, TimeUnit.SECONDS);
	}

	public static void testOpenCloseConnections() {
		try {
			for (int i = 0; i < MAX_ITERATIONS; i++) {
				Timer.Context context = timer.time();
				getDataSource().getConnection();				
				context.stop();
				
			}
			consoleReporter.report();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
