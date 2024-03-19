package com.xzit.practice.designModel.observer;

/**
 * <p>
 * 该类用于：
 * </p>
 *
 * @author leizf
 * @since 2024-03-19 18:01
 */
public class Demo {

    public static void main(String[] args) {
        Topic topicSon0 = new TopicSon0();
        ObserverImpl observer1 = new ObserverImpl();
        ObserverImpl observer2 = new ObserverImpl();
        ObserverImpl observer3 = new ObserverImpl();

        topicSon0.addObserver(observer1);
        topicSon0.addObserver(observer2);
        topicSon0.addObserver(observer3);

        topicSon0.updateAllObservers(300);
//        System.out.println(observer1.getState());
//        System.out.println(observer2.getState());
//        System.out.println(observer3.getState());

        topicSon0.updateAllObservers(400);
//        System.out.println(observer1.getState());
//        System.out.println(observer2.getState());
//        System.out.println(observer3.getState());
    }
}
