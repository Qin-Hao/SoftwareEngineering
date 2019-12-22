package ouc.cs.oceanfish.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DbUtil class
 *
 * @author qinhao
 * @date 2019/12/03
 */

public class DbUtil {
    /**
     *  数据库连接常量
     */
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "19980924qh";

    /**
     * 连接数据库
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭连接
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭preparedStatement
     */
    public static void closePstmt(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭resultSet
     */
    public static void closeRst(ResultSet rst) {
        try {
            rst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
