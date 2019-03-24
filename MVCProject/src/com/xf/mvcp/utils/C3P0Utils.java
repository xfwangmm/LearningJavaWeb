package com.xf.mvcp.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0 utils
 */
public class C3P0Utils {
    /**
     * mysql数据源
     */
    static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource("mysql");
    }

    /**
     * 获取数据源的数据连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 关闭数据连接
     * @param conn
     */
    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
