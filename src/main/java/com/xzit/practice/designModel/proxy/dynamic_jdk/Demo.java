package com.xzit.practice.designModel.proxy.dynamic_jdk;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 11:06
 */
public class Demo {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userDao);
        UserDao proxy = (UserDao) myInvocationHandler.getProxy();
        proxy.add();

        MyRoleInvocationHandler myRoleInvocationHandler = new MyRoleInvocationHandler(RoleDao.class);
        RoleDao proxy1 = (RoleDao) myRoleInvocationHandler.getProxy();
        proxy1.add();
    }
}
