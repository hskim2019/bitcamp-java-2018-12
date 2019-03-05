package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// DAO마다 커넥션을 생성하기는 번거롭기 때문에
	// 커넥션을 빌려주고 리턴 받는 일을 한다
	
	public static Connection create() {
	
		try {
		return DriverManager.getConnection(
				"jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111");
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
