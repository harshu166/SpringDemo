package com.fico.demo.dal.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fico.data.ds.HikariDataSourceFactory;

@Configuration
@Component
public class DataSourceConfiguration {
	
	@Bean(name="dataSource")
    @Primary
    public static DataSource getDataSource() {
        return HikariDataSourceFactory.getTransactional();
    }

}
