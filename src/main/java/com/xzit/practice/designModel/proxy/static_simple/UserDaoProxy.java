package com.xzit.practice.designModel.proxy.static_simple;

/**
 * <p>
 * 该类用于：静态代理
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 10:53
 */
public class UserDaoProxy extends UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("事务开启");
        userDao.add();
        System.out.println("事务关闭");
    }
}
