package com.wei.activiti;

import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.DeploymentBuilder;

import java.util.UUID;

/**
 * @Author:Shenzhiwei
 * @Desicription:初始化数据
 * @Date:Created in 2018-07-03 14:15
 * @Modified By:
 */
public class InitData {
    public static void main(String[] args) {
        /**创建默认流程引擎*/
        ProcessEngine engine= ProcessEngines.getDefaultProcessEngine();
        /**获取身份验证服务*/
       IdentityService identityService=engine.getIdentityService();
       /**生成部门经理UUID*/
       String genId= UUID.randomUUID().toString();
       Group group=identityService.newGroup(genId);
       group.setName("部门经理");
       group.setType("manager");
       identityService.saveGroup(group);
        /**创建部门经理用户*/
       String  userId= UUID.randomUUID().toString();
        User user=identityService.newUser(userId);
        user.setFirstName("Wang");
        user.setLastName("Er");
        user.setEmail("zhiwei.shen@aorise.org");
        user.setPassword("123");
        identityService.saveUser(user);
        /**绑定关系*/
        identityService.createMembership(userId,genId);
        /**生成副总uuid*/
       genId=UUID.randomUUID().toString();
        group=identityService.newGroup(genId);
        group.setName("中心副总");
        group.setType("manager");
        identityService.saveGroup(group);
        /**生成用户id*/
         userId= UUID.randomUUID().toString();
         user=identityService.newUser(userId);
        user.setFirstName("Zhang");
        user.setLastName("San");
        user.setEmail("zhiwei.shen@aorise.org");
        user.setPassword("123");
        identityService.saveUser(user);
        /**绑定关系*/
        identityService.createMembership(userId,genId);

        /**生成人事uuid*/
        genId=UUID.randomUUID().toString();
        group=identityService.newGroup(genId);
        group.setName("人事专员");
        group.setType("manager");
        identityService.saveGroup(group);
        /**创建人事用户*/
        userId= UUID.randomUUID().toString();
        user=identityService.newUser(userId);
        user.setFirstName("Li");
        user.setLastName("Si");
        user.setEmail("zhiwei.shen@aorise.org");
        user.setPassword("123");
        identityService.saveUser(user);
        /**绑定关系*/
        identityService.createMembership(userId,genId);

        /**部署流程图*/
        RepositoryService repositoryService=engine.getRepositoryService();
        DeploymentBuilder builder=repositoryService.createDeployment();
        builder.addClasspathResource("workflowfile/Leave.bpmn").deploy();

    }
}
