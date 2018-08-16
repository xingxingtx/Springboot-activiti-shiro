package com.wei.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @Author:Shenzhiwei
 * @Desicription:
 * @Date:Created in 2018-07-09 08:40
 * @Modified By:
 */
public class GetTaskByUser {
    public static void main(String[] args){
        /**创建流程引擎*/
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        TaskService taskService=processEngine.getTaskService();
        /**根据用户查询当前拥有的任务*/
        List<Task> taskList=taskService.createTaskQuery().taskOwner("47111da4-c81c-49bb-9478-b1d4c183d2be").list();
        for (Task task : taskList) {
            System.out.print("当前用户的任务有："+task.getId());
        }
    }
}
