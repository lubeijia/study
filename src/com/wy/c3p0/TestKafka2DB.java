package com.wy.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestKafka2DB {
//	private static Statement st = null;
	private static PreparedStatement ps = null;
	private static Connection cn = null;
	private static ComboPooledDataSource ds = new ComboPooledDataSource();

	public TestKafka2DB() {
		try {
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/test_deployandcontrol?useUnicode=true&characterEncoding=UTF-8");
			ds.setUser("root");
			ds.setPassword("wuyong");
			ds.setMaxPoolSize(10);
			ds.setInitialPoolSize(3);
			ds.setMaxIdleTime(2000);
			cn = ds.getConnection();
//			st = cn.createStatement();
			String sql = "insert into `user` (name,age) values(?,?)";
			ps = cn.prepareStatement(sql);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean insertData(String[] str) {
		try {
			ps.setString(1, str[0]);
			ps.setInt(2, Integer.parseInt(str[1]));
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("sql语句执行失败！");
			e.printStackTrace();
		}
		return false;
	}
}
