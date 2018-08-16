package com.wei.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.history.HistoricProcessInstance;

import java.util.List;

/**
 * @Author:Shenzhiwei
 * @Desicription:历史数据查询
 * @Date:Created in 2018-07-04 14:40
 * @Modified By:
 */
public class History {


    public static void main(String[] args){
        /**创建流程引擎*/
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        /**得到流程引擎存储服务实例*/
        RepositoryService repositoryService=processEngine.getRepositoryService();
        /**得到历史服务组件*/
        HistoryService historyService=processEngine.getHistoryService();

        List<HistoricProcessInstance> list=historyService.createHistoricProcessInstanceQuery().finished().list();
        for (HistoricProcessInstance historicProcessInstance : list) {
            System.out.print(historicProcessInstance.getId());
        }
    }
}

