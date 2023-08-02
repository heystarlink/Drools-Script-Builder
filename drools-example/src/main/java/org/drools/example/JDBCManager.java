package org.drools.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : kenny
 * @since : 2023/7/15
 **/
public class JDBCManager {
    private String url;
    private String user;
    private String pwd;
    private static Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/inr";
            String username = "root";
            String password = "123456";

            // 创建与MySQL数据库的连接类的实例
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
