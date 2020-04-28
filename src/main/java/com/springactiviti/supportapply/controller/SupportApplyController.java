package com.springactiviti.supportapply.controller;

import com.springactiviti.util.AjaxResult;
import com.springactiviti.util.LogBack;
import com.springactiviti.util.StringUtils;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Chb
 * @Date 2020/4/5 13:27
 **/
@RestController
public class SupportApplyController {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    @PostMapping("/runActiviti")
    public AjaxResult runActiviti(@RequestParam("item") String item,
                                  @RequestParam("supApplyId") String supApplyId) {
        String processDefinitionKey = "item-" + item;
        LogBack.info("runActiviti-item = " + processDefinitionKey);
        runtimeService.startProcessInstanceByKey(processDefinitionKey, supApplyId);

        return AjaxResult.success();
    }

    @PostMapping("/lobourActiviti")
    public AjaxResult lobourActiviti(@RequestParam("supApplyId") String supApplyId,
                                     @RequestParam("acstatus") String acstatus) {
        LogBack.info("手动审核：supApplyId = " + supApplyId);
        LogBack.info("手动审核状态：acstatus = " + acstatus);
        
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(supApplyId)
                .taskAssignee("admin")
                .singleResult();
        if(task!=null){
            if(StringUtils.isNotEmpty(acstatus)){
                taskService.setVariable(task.getId(),"acstatus",acstatus);
            }
            taskService.complete(task.getId());
        }

        return AjaxResult.success();
    }
}
