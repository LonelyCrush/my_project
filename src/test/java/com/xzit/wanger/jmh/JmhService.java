package com.xzit.wanger.jmh;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author leizefeng
 */
@Service
public class JmhService {

    private int n = 10000;
    private List<Integer> arrayList;
    private List<Integer> linkedList;

    public JmhService() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }

    public void scannerArrayList() {
        for (int i = 0; i < n; i++) {
            arrayList.get(i);
        }
    }

    public void scannerLinkedList() {
        for (int i = 0; i < n; i++) {
            linkedList.get(i);
        }
    }

    public void clear() {
        arrayList.clear();
        linkedList.clear();
    }
}
