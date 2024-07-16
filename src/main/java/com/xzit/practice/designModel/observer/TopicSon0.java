package com.xzit.practice.designModel.observer;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:59
 */
public class TopicSon0 extends Topic {

    private Integer state;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
        this.updateAllObservers(state);
    }
}
