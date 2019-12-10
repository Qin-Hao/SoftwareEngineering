package ouc.cs.oceanfish.service;

import ouc.cs.oceanfish.dao.UserDao;
import ouc.cs.oceanfish.po.User;

/**
 * UserService
 *
 * @author qinhao
 * @date 2019/12/03
 */

public class UserService {
    private UserDao userDao = new UserDao();

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
}
