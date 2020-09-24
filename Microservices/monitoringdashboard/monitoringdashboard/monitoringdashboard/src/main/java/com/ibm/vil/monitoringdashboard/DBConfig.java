/**
 * 
 */
package com.ibm.vil.monitoringdashboard;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
public class DBConfig {
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name="dataSource")
    public DataSource dataSource() {
		DriverManagerDataSource dataSource = null;
        try{
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ibmproject");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
        }catch (Exception ex) {
        	ex.printStackTrace();
        }
        return dataSource;
    }
	

}
