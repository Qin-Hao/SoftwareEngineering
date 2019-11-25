package ouc.cs.oceanfish.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DbUtil class
 *
 * @author qinhao
 * @date 2019/11/17
 */

public class DbUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://192.168.232.1:3306/test_android";
    private static String user = "local";
    private static String password = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
