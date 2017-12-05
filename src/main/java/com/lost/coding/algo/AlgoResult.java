package com.lost.coding.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishoubo on 17/12/4.
 */
public class AlgoResult {
    private String name;
    private Map<Integer, Long> timeMap;

    public AlgoResult() {
        timeMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Long> getTimeMap() {
        return timeMap;
    }

    public void setTimeMap(Map<Integer, Long> timeMap) {
        this.timeMap = timeMap;
    }

    public void addTime(int n, long time) {
        timeMap.put(n, time);
    }
}
