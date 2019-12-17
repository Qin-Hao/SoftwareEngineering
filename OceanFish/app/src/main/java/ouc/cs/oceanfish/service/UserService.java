package ouc.cs.oceanfish.service;

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


    public Goods addGoods(Goods goods)
    {
        goodsDao.addGoods(goods);
    }
}
