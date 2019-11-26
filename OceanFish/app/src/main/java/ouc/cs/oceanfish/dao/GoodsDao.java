package ouc.cs.oceanfish.dao;
import ouc.cs.oceanfish.po.Goods;

public class GoodsDao {

    //增加物品信息，无条件增加到待审核表
    public boolean addGoods(Goods goods){
        return true;
    }

    //增加物品信息到通过审核表
    public boolean addGoodsSecond(Goods goods){
        return true;
    }

    //删除物品信息，通过匹配id删除
    public boolean deleteGoods(int id){
        return true;
    }

    //修改物品信息，通过id搜索，修改为传送的信息
    public boolean updateGoods(int id, Goods goods){
        return true;
    }

    //通过id搜索唯一的物品
    public boolean findGoodsById(int id){
        return true;
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
