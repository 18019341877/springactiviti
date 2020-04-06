package com.test.activiti.supportapply.server;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @Author Chb
 * @Date 2020/4/5 15:03
 **/
public class ServiceTask implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) {

        try {

            System.out.println("serviceTask已经执行已经执行！");
            System.out.println(execution.getEventName()+"--"+execution.getId()+"--"+execution.getProcessBusinessKey());
            //获取查询器
//            String istg = execution.getVariable("istg").toString();
//            System.out.println("---------！" + istg);
            execution.setVariable("istg", 2);

        } catch (Exception e){

        }

    }
}
