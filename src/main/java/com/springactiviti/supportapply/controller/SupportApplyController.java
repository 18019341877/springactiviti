package com.springactiviti.supportapply.controller;

import com.springactiviti.util.AjaxResult;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @Author Chb
 * @Date 2020/4/5 13:27
 **/
@RestController
public class SupportApplyController {

    @Autowired
    RuntimeService runtimeService;

    @PostMapping("/runActiviti")
    public AjaxResult runActiviti(@RequestParam("itemid") String itemid,
                                  @RequestParam("applyid") String applyid) {
        String processDefinitionKey = "itemid-" + itemid;

        //开启流程，得到流程实例对象
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, applyid);

        return AjaxResult.success();
    }
}
