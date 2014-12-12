package com.saga.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.saga.model.dto.HumanResource;

/**
 * @author simjisung
 * @see RootContext는 기본적인 DataSource 설정과 하이버네이트 설정 (혹은 JPA) 빈설정 하는 부분으로, 
 * 과거 xml로 빈 등록 했던 부분을 자바 코드로 변형 시킨 산출물 이다. 
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.saga.model.*")
public class RootContext {
	
	/*
	 * JDBC Properties
	 */
	@Value("${database.driver}")
	private String jdbcDriverClassName;
	
	@Value("${database.url}")
	private String jdbcUrl;
	
	@Value("${database.user}")
	private String jdbcUser;
	
	@Value("${database.password}")
	private String jdbcPassword;
	
	/*
	 * Hibernate Properties 
	 */
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.show_sql}")
	private String showSql;
	
	@Value("${hbm2ddl.auto}")
	private String hbm2ddl;
	
	
	private static final String JDBC_CONFIG_PROPERTIES_PATH = "jdbc.properties";
	
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(new Resource[] {
				new ClassPathResource(JDBC_CONFIG_PROPERTIES_PATH)
		});
		return ppc;
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.jdbcDriverClassName);
		dataSource.setUrl(this.jdbcUrl);
		dataSource.setUsername(this.jdbcUser);
		dataSource.setPassword(this.jdbcPassword);
		return dataSource;
	}
	
	@Bean 
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		localSessionFactory.setDataSource(dataSource());
		//localSessionFactory.setAnnotatedClasses(HumanResource.class);
		localSessionFactory.setPackagesToScan(new String[] {"com.saga.model.dto"});
	
		Properties hibernateProperties = hibernateProperties();
		
		localSessionFactory.setHibernateProperties(hibernateProperties);
		
		return localSessionFactory;
	}

	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", this.hibernateDialect);
		hibernateProperties.setProperty("hibernate.show_sql", this.showSql);
		hibernateProperties.setProperty("hbm2ddl", this.hbm2ddl);
		return hibernateProperties;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory().getObject());
		return htm;
	}
	
}
