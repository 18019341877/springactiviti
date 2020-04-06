package com.test.activiti.supportapply.controller;

import com.test.activiti.activiti.config.Cfg_Activiti;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @Author Chb
 * @Date 2020/4/5 13:27
 **/
@RestController
public class SupportApplyController {

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;

    @GetMapping("/runActiviti")
    public String runActiviti() {

        //获取查询器
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey("process")
                .orderByProcessDefinitionVersion().desc().list();
        for (int i = 0; i < list.size(); i++) {
            ProcessDefinition processDefinition = list.get(i);
            System.out.println("流程定义id：" + processDefinition.getId());
            System.out.println("流程定义名称：" + processDefinition.getName());
            System.out.println("流程定义key：" + processDefinition.getKey());
            System.out.println("流程定义版本：" + processDefinition.getVersion());
            System.out.println("流程部署id：" + processDefinition.getDeploymentId());
            BpmnModel model = repositoryService.getBpmnModel(processDefinition.getId());
            if (model != null) {
                Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
                for (FlowElement e : flowElements) {
                    System.out.println("--flowelement id:" + e.getId() + "  name:" + e.getName() + "   class:" + e.getClass().toString());
                }
            }
        }

        String processDefinitionKey = "process";
        //开启流程，得到流程实例对象
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println(processInstance);


        return null;
    }
}
