package com.test.activiti.supportapply.server;

import com.alibaba.fastjson.JSON;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author Chb
 * @Date 2020/4/5 15:03
 **/
public class ServiceTask implements JavaDelegate {


    private Expression methodName;

    @Override
    public void execute(DelegateExecution execution) {

        execution.setVariable("isover", "通过");

        try {
            System.out.println("serviceTask已经执行已经执行！");
            System.out.println(execution.getEventName() + "--" + execution.getId() + "--" + execution.getProcessBusinessKey());
            System.out.println(execution.getParentId());
            System.out.println(execution.getProcessDefinitionId());
            System.out.println(execution.getProcessInstanceId());
            System.out.println(execution.getId());
            System.out.println(execution.getCurrentActivityName());
            String value1 = (String) methodName.getValue(execution);
//            String value1 = execution.getVariable("text1").toString();
            System.out.println(value1);
            //获取查询器
//            String istg = execution.getVariable("istg").toString();
//            System.out.println("---------！" + istg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
