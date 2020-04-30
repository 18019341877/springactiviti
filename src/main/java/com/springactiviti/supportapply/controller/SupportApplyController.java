package com.springactiviti.supportapply.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

import java.util.List;

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

        List<Task> task = taskService.createTaskQuery().processInstanceBusinessKey(supApplyId)
                .taskAssignee("admin").list();
        if (task != null && !task.isEmpty()) {
            String taskid = task.get(task.size() - 1).getId();
            if (StringUtils.isNotEmpty(acstatus)) {
                taskService.setVariable(taskid, "acstatus", acstatus);
            }
            taskService.complete(taskid);
        }

        return AjaxResult.success();
    }
}
