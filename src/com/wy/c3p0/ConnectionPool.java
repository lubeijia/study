package com.wy.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库连接池.
 * 
 * @author wuyong
 * @date 2015年11月17日
 */
public class ConnectionPool {
    private DataSource ds;
    private static ConnectionPool pool;

    private ConnectionPool() {
        ds = new ComboPooledDataSource();
    }

    /**
     * 获取数据库连接池单例对象.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @return 数据库连接池
     */
    public static final ConnectionPool getInstance() {
        if (pool == null) {
            try {
                pool = new ConnectionPool();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pool;
    }

    /**
     * 获取数据库连接对象.
     * 
     * @author wuyong
     * @date 2015年11月17日
     * @return 数据库连接对象
     */
    public final synchronized Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 数据库关闭操作.
     * 
     * @param conn
     *            数据库连接对象
     * @param ps
     *            数据库操作句柄
     * @param rs
     *            结果集
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
