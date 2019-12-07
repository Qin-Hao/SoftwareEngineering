package ouc.cs.oceanfish.dao;

import org.junit.Test;

import ouc.cs.oceanfish.po.User;

public class UserDaoTest {

    User user;
    UserDao userDao;

    @Test
    public void addUser() {
        user = new User(1, "17020031052", "123456789");
        int result = userDao.addUser(user);
        System.out.println(result);
    }

    @Test
    public void delUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void findUserByName() {
    }
}