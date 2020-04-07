package com.test.activiti.supportapply.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Chb
 * @Date 2020/4/5 13:27
 **/
@RestController
public class SupportApplyController {

    @Autowired
    RuntimeService runtimeService;

    @PostMapping("/runActiviti")
    public String runActiviti(@RequestParam(name = "itemid") String itemid ,
                              @RequestParam(name = "applyid") String applyid) {
        String processDefinitionKey = "itemid-" + itemid;
        System.out.println("processDefinitionKey = " + processDefinitionKey);
        //获取查询器
//        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
//        List<ProcessDefinition> list = processDefinitionQuery.processDefinitionKey(processDefinitionKey)
//                .orderByProcessDefinitionVersion().desc().list();
//        for (int i = 0; i < list.size(); i++) {
//            ProcessDefinition processDefinition = list.get(i);
//            System.out.println("流程定义id：" + processDefinition.getId());
//            System.out.println("流程定义名称：" + processDefinition.getName());
//            System.out.println("流程定义key：" + processDefinition.getKey());
//            System.out.println("流程定义版本：" + processDefinition.getVersion());
//            System.out.println("流程部署id：" + processDefinition.getDeploymentId());
//            BpmnModel model = repositoryService.getBpmnModel(processDefinition.getId());
//            if (model != null) {
//                Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
//                for (FlowElement e : flowElements) {
//                    System.out.println("--flowelement id:" + e.getId() + "  name:" + e.getName() + "   class:" + e.getClass().toString());
//                }
//            }
//        }

        //开启流程，得到流程实例对象
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, applyid);
        System.out.println(processInstance);


        return null;
    }
}
