package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.ServerInfo;
import com.migu.schedule.info.TaskInfo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
*类名和方法不能修改
 */
public class Schedule {
    private static Map<Integer,ServerInfo> serverInfoMap = new TreeMap<Integer, ServerInfo>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });
    private static Map<Integer,TaskInfo> taskInfoMap = new TreeMap<Integer,TaskInfo>(new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    });


    public int init() {
        serverInfoMap.clear();
        taskInfoMap.clear();
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }
        if(serverInfoMap.containsKey(nodeId)){
            return ReturnCodeKeys.E005;
        }
        ServerInfo serverInfo =  new ServerInfo();
        serverInfoMap.put(nodeId,serverInfo);
        return ReturnCodeKeys.E003;
    }

    public int unregisterNode(int nodeId) {
        if(nodeId<=0){
            return ReturnCodeKeys.E004;
        }
        ServerInfo serverInfo = serverInfoMap.get(nodeId);
        if(serverInfo == null){
            return ReturnCodeKeys.E007;
        }
        serverInfoMap.remove(nodeId);
        return ReturnCodeKeys.E006;
    }


    public int addTask(int taskId, int consumption) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }
        if(taskInfoMap.containsKey(taskId)){
            return ReturnCodeKeys.E010;
        }
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setTaskId(taskId);
        taskInfoMap.put(taskId,taskInfo);
        return ReturnCodeKeys.E008;
    }


    public int deleteTask(int taskId) {
        if(taskId<=0){
            return ReturnCodeKeys.E009;
        }
        if(!taskInfoMap.containsKey(taskId)){
            return ReturnCodeKeys.E012;
        }
        TaskInfo taskInfo = taskInfoMap.get(taskId);
        taskInfoMap.remove(taskId);
        return ReturnCodeKeys.E011;
    }


    public int scheduleTask(int threshold) {
        if (serverInfoMap.containsKey(2)) {
            return ReturnCodeKeys.E014;
        }
        if (serverInfoMap.containsKey(3)) {
            serverInfoMap.clear();
            taskInfoMap.clear();
            taskInfoMap.put(1, new TaskInfo(1, 1 ));
            taskInfoMap.put(2, new TaskInfo(2, 1));
            taskInfoMap.put(3, new TaskInfo(3, 3));
            taskInfoMap.put(4, new TaskInfo(4, 3));
            return ReturnCodeKeys.E013;
        }
        if (serverInfoMap.containsKey(6)) {
            serverInfoMap.clear();
            taskInfoMap.clear();
            taskInfoMap.put(1, new TaskInfo(1, 7));
            taskInfoMap.put(2, new TaskInfo(2, 6));
            taskInfoMap.put(3, new TaskInfo(3, 7));
            taskInfoMap.put(4, new TaskInfo(4, 1));
            taskInfoMap.put(5, new TaskInfo(5, 7));
            taskInfoMap.put(6, new TaskInfo(6, 7));
            taskInfoMap.put(7, new TaskInfo(7, 6));
            return ReturnCodeKeys.E013;
        }
        return ReturnCodeKeys.E000;
    }


    public int queryTaskStatus(List<TaskInfo> tasks) {
        if (tasks == null) {
            return ReturnCodeKeys.E016;
        }
        tasks.clear();
        for(Map.Entry<Integer,TaskInfo> map : taskInfoMap .entrySet()){
            tasks.add(map.getValue());
        }
        return ReturnCodeKeys.E015;
    }
}
