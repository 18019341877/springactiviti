package com.springactiviti.supportapply.server;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 服务任务监听器
 * @Author Chb
 * @Date 2020/4/5 15:03
 **/
public class ServiceTask implements JavaDelegate {

    private Expression methodName;

    @Override
    public void execute(DelegateExecution execution) {
        String name = execution.getCurrentActivityName();
        try {
            System.out.println(name + "开始执行！");
            String taskmethodName = (String) methodName.getValue(execution);
            System.out.println("taskmethodName:" + taskmethodName);
            String over = (String)execution.getVariable("isover");
            System.out.println("over = " + over);
            if ("营业执照识别".equals(name)) {
                execution.setVariable("isover", "不通过");
            }
            System.out.println(name + "serviceTask已经执行已经执行！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
