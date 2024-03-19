package com.xzit.practice.designModel.proxy.dynamic_jdk;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 11:02
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("新增用户");
    }
}
