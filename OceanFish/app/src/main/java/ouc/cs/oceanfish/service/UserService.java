package ouc.cs.oceanfish.service;

import java.util.Vector;

import ouc.cs.oceanfish.dao.UserDao;
import ouc.cs.oceanfish.po.User;
import ouc.cs.oceanfish.po.Goods;
import ouc.cs.oceanfish.dao.GoodsDao;

public class UserService {
    private UserDao userDao = new UserDao();
    private GoodsDao goodsDao = new GoodsDao();

    /**
     * register
     * @param user a user that will register
     * @return userDao.addUser(user)
     */
    public int register(User user) {
        User u = userDao.findUserByName(user.getName());
        if (u != null) {
            return -1;
        }
        return userDao.addUser(user);
    }

    public int delUser(int id) {
        return userDao.delUser(id);
    }

    public int updateUser(int id, User user) {
        return userDao.updateUser(id, user);
    }

    /**
     * findUserByName
     * @param username find the user with this name
     * @return user
     */
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    /**
     * findUserById
     * @param id find the user with this id
     * @return user
     */
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }


    public int addGoods(Goods goods)
    {
        return goodsDao.addGoods(goods);
    }

    public int deleGoods(int id){
        return goodsDao.deleteGoods(id);
    }

    public  int updateGoods(int id,Goods goods){
        goods.setSoldStatus("under review");
        return goodsDao.updateGoods(id,goods);
    }

    public Goods findGoodsById(int id){
        return goodsDao.findGoodsById(id);
    }

    public Vector<Goods> findGoodsByName(String name){
        return goodsDao.findGoodsByName(name);
    }

    public Vector<Goods> findGoodsByUserId(int userId){
        return goodsDao.findGoodsByUserId(userId);
    }

    public Vector<Goods> findGoodsByAdresss(String address){
        return goodsDao.findGoodsByAddress(address);
    }

    public Vector<Goods> findGoodsByType(String type){
        return goodsDao.findGoodsByType(type);
    }

    public Vector<Goods> findGoodsBySoldStatus(String soldStatus){
        return goodsDao.findGoodsBySoldStatus(soldStatus);
    }

    public Vector<Goods> findAllGoods(){
        return goodsDao.findAllGoods();
    }
}
