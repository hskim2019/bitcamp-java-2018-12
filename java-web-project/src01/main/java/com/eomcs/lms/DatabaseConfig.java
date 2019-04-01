package com.eomcs.lms;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // Spring IoC 컨테이너 설정을 수행하는 클래스임을 표시한다
// .properties 파일을 로딩시키는 애노테이션
@PropertySource("classpath:/com/eomcs/lms/conf/jdbc.properties")
// Spring의 트랜잭션 관리자를 활성화시킬 때 사용한다
// 등록되어있는 Spring Bean 중에서 PlatformTransactionManager 인터페이스 구현한 클래스타입의 Bean을 찾아서 이것을 트랜잭션 메니저로 사용
@EnableTransactionManagement 

public class DatabaseConfig {

	// @Autowired 
	//=> 빈 컨테이너에서 지정한 타입의 값을 꺼내 필드에 넣으라는 명령이다
	@Autowired Environment env;

	@Bean
	public DataSource dataSource() {
		// DBMS정보는 jdbc.properties 파일에 있다
		// Spring IoC 컨테이너에서 주입 받은 env 객체를 사용하여 이 파일의 값을 꺼내면 된다
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager (DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	

}
