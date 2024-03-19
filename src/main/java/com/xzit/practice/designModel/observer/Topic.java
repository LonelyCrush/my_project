package com.xzit.practice.designModel.observer;

import java.util.Vector;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 17:55
 */
public class Topic {

    private Vector<Observer> observers = new Vector<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void updateAllObservers(int state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
