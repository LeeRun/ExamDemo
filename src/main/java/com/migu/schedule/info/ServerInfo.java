package com.migu.schedule.info;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Q on 2018/6/20.
 */
public class ServerInfo {

    private int consumption;

    private Map<Integer,TaskInfo> taskMap = new HashMap<Integer,TaskInfo>();

    public int getConsumption() {
        return consumption;
    }

    public Map<Integer, TaskInfo> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<Integer, TaskInfo> taskMap) {
        this.taskMap = taskMap;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public void removoTask(int taskId){
        taskMap.remove(taskId);
    }
}
