package com.xzit.practice.designModel.template;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 16:28
 */
public abstract class RestaurantTemplate {

    // 1.看菜单
    private void menu() {
        System.out.print("  看菜单");
    }

    // 2.点菜业务
    abstract void order();

    // 3.吃饭业务
    private void eat(){ System.out.print("  吃饭"); }

    // 4.付款业务
    abstract void pay();

    // 5.走人
    private void go() { System.out.print("  走人"); }

    // 模板通用结构
    public void consume() {
        menu();
        order();
        eat();
        pay();
        go();
        System.out.println();
    }
}
