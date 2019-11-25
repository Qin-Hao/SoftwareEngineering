package ouc.cs.oceanfish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ouc.cs.oceanfish.po.User;
import ouc.cs.oceanfish.util.DbUtil;

/**
 * UserDao class
 *
 * @author qinhao
 * @date 2019/11/19
 */

public class UserDao {

    /**
     * addUser
     * @param user A User object
     * @return result
     */
    public int addUser(User user) {
       Connection conn = DbUtil.getConnection();
       String sql = "insert into users(username,password) value(?,?)";
       Statement st = null;
       int result = 0;
       try {
           st = conn.createStatement();
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, user.getName());
           ps.setString(2, user.getPassword());

           result = ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
               if (st != null) {
                   st.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return result;
   }

   /**
    * delUser
    * @param id user's id
    * @return result
    */
   public int delUser(int id) {
       Connection conn = DbUtil.getConnection();
       String sql = "delete from users where id = ?";
       Statement st = null;
       int result = 0;
       try {
           st = conn.createStatement();
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, id);

           result = ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
               if (st != null) {
                   st.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return result;
   }

    /**
     * updateUser
     * @param id user's id in the users table
     * @param user A User object
     * @return result
     */
   public int updateUser(int id, User user) {
       Connection conn = DbUtil.getConnection();
       String sql = "update users set userame = ?, password = ? where id = ?";
       Statement st = null;
       int result = 0;
       try {
           st = conn.createStatement();
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, user.getName());
           ps.setString(2, user.getPassword());
           ps.setInt(3, id);

           result = ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           try {
               if (st != null) {
                   st.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return result;
   }

    /**
     * findUserByName
     * @param username the name that the user you want to find has
     * @return user
     */
   public User findUserByName(String username) {
       Connection conn = DbUtil.getConnection();
       String sql = "select * from users where username = ?";
       PreparedStatement ps;
       ResultSet rs;
       User user = null;
       try {
           ps = conn.prepareStatement(sql);
           ps.setString(1, username);
           rs = ps.executeQuery();
           if (rs.next()) {
               user = new User(rs.getInt(1), rs.getString(2),
                       rs.getString(3));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return user;
   }
}
