package com.o2o.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 *继承TransactionManagementConfigurer要开启annotation-driver（支持事务注解）
 * 对应spring-service里面的transactionManager
 */

@Configuration
//使用注解@EnableTransactionManagement开启事务支持
//在Service方法上添加注解@Transactional便可开启事务
@EnableTransactionManagement
public class TransactionManagementConfiguration implements TransactionManagementConfigurer {
	@Autowired
	//注入 DataSourceConfiguration 中创建的DataSource
	//通过createDataSource()方法获取
	private DataSource dataSource;

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {

		//关于事务管理的方法，需要返回PlatformTransactionManager的实现
		return new DataSourceTransactionManager(dataSource);
	}
	//extends AbstractPlatformTransactionManager
	//
}
