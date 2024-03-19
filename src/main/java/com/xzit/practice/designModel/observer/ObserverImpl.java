package com.xzit.practice.designModel.observer;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:52
 */
public class ObserverImpl implements Observer {

    private Integer state;

    public Integer getState() {
        return state;
    }

    @Override
    public void update(int state) {
        System.out.println("收到消息，state的值由【" + this.state + "】变为【" + state + "】");
        this.state = state;
    }
}
