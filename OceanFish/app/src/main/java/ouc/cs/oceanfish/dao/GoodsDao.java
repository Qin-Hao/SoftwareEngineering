package ouc.cs.oceanfish.dao;
import ouc.cs.oceanfish.po.Goods;
import ouc.cs.oceanfish.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            ps.setInt( 10,goods.getId());

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
        Goods goods = null;
        return goods;
    }

    //通过name搜索一种物品
    public boolean findGoodsByName(String name){
        return true;
    }

    //通过userId搜索一些物品
    public boolean findGoodsByUserId(int userId){
        return true;
    }

    //通过address搜索一些物品
    public boolean findGoodsByAddress(String address){
        return true;
    }

    //通过type搜索一类物品
    public boolean FindGoodsByType(String typr){
        return true;
    }

    //搜索所有物品
    public boolean FindAllGoods(){
        return true;
    }
}
