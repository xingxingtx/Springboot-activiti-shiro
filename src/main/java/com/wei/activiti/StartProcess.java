package com.wei.activiti;

import org.activiti.engine.*;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Shenzhiwei
 * @Desicription:
 * @Date:Created in 2018-07-03 17:40
 * @Modified By:
 */
public class StartProcess {

    public static void main(String[] agar) {
        /**创建默认流程引擎*/
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        /**获取运行服务组件*/
        RuntimeService runtimeService = engine.getRuntimeService();
        /**设置临时参数*/
        Map<String, Object> vars = new HashMap<String, Object>();
        vars.put("days", 3);
        /**启动流程*/
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", vars);
        /**获取任务服务组件*/
        TaskService taskService = engine.getTaskService();
        /**获取任务*/
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        System.out.print(task.getName());
        /**完成任务*/
        taskService.complete(task.getId());
        /**部门经理审批*/
        task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        /**获取身份服务组件*/
        IdentityService identityService=engine.getIdentityService();
        User user=identityService.createUserQuery().userFirstName("Wang").singleResult();
        taskService.setOwner(task.getId(),user.getId());
        taskService.complete(task.getId());
        /**副总审批*/
        taskService.complete(task.getId());
        /**人事审批*/
        task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        /**获取身份服务组件*/
        task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        /**获取身份服务组件*/
        identityService=engine.getIdentityService();
        user=identityService.createUserQuery().userFirstName("Li").singleResult();
        taskService.setOwner(task.getId(),user.getId());
        identityService=engine.getIdentityService();
        user=identityService.createUserQuery().userFirstName("Zhang").singleResult();
        taskService.setOwner(task.getId(),user.getId());
        /**设置候选组*/
        //taskService.addCandidateGroup(task.getId(),"123");
        taskService.complete(task.getId());
    }
}
