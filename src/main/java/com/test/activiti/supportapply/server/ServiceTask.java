package com.test.activiti.supportapply.server;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @Author Chb
 * @Date 2020/4/5 15:03
 **/
public class ServiceTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("serviceTask已经执行已经执行！");

    }
}
