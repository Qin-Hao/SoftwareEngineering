package ouc.cs.oceanfish.dao;

import ouc.cs.oceanfish.po.Goods;
import ouc.cs.oceanfish.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GoodsDao {

    //增加物品信息
    public int addGoods(Goods goods){
        Connection conn = DbUtil.getConnection();
        String sql = "insert into goods(userId,name,picture,price,contactWay,address," +
                "describe,type,soldStatus) value (?,?,?,?,?,?,?,?,?)";
        Statement st = null;
        int result = 0;
        try {
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getUserId() );
            ps.setString( 2,goods.getName());
            ps.setString( 3,goods.getPicture());
            ps.setDouble( 4,goods.getPrice());
            ps.setString( 5,goods.getContactWay());
            ps.setString( 6,goods.getAddress());
            ps.setString( 7,goods.getDescribe());
            ps.setString( 8,goods.getType());
            ps.setString( 9,goods.getSoldStatus());

            result = ps.executeUpdate();
        } catch (SQLException e){
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

    //删除物品信息，通过匹配id删除
    public int deleteGoods(int id){
        Connection conn = DbUtil.getConnection();
        String sql = "delete from goods where id = ?";
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

    //修改物品信息，通过id搜索，修改为传送的信息
    public int updateGoods(int id, Goods goods){
        Connection conn = DbUtil.getConnection();
        String sql = "update goods set userId = ? , name = ? , picture = ? , price = ? , " +
                "contactWay = ? , address = ? , describe = ? , type = ? , soldStatus = ? where " +
                "id = ?";
        Statement st = null;
        int result = 0;
        try {
            st = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,goods.getUserId() );
            ps.setString( 2,goods.getName());
            ps.setString( 3,goods.getPicture());
            ps.setDouble( 4,goods.getPrice());
            ps.setString( 5,goods.getContactWay());
            ps.setString( 6,goods.getAddress());
            ps.setString( 7,goods.getDescribe());
            ps.setString( 8,goods.getType());
            ps.setString( 9,goods.getSoldStatus());
            ps.setInt( 10,id);

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

    //通过id搜索唯一的物品
    public Goods findGoodsById(int id){
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where id = ?";
        PreparedStatement ps;
        ResultSet rs;
        Goods goods = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                goods = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //通过name搜索一种物品
    public Vector<Goods> findGoodsByName(String name){
        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where name = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //通过userId搜索一些物品
    public Vector<Goods> findGoodsByUserId(int userId){
        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where userId = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;

    }

    //通过address搜索一些物品
    public Vector<Goods> findGoodsByAddress(String address){

        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where address = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, address);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //通过type搜索一类物品
    public Vector<Goods> findGoodsByType(String type){

        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where type = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //通过soldStatus搜索一些物品
    public Vector<Goods> findGoodsBySoldStatus(String soldStatus)
    {

        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods where soldStatus = ?";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, soldStatus);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }

    //搜索所有物品
    public Vector<Goods> findAllGoods(){
        Vector<Goods> goods = new Vector<>();
        Connection conn = DbUtil.getConnection();
        String sql = "select * from goods ";
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Goods g;
                g = new Goods(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4),
                        rs.getDouble(5),rs.getString(6),
                        rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10));
                goods.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
    }
}
