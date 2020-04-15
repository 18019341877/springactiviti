package com.springactiviti.supportapply.server;

import com.alibaba.fastjson.JSONObject;
import com.springactiviti.util.Config;
import com.springactiviti.util.LogBack;
import com.springactiviti.util.StringUtils;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 服务任务监听器
 *
 * @Author Chb
 * @Date 2020/4/5 15:03
 **/
public class ServiceTask implements JavaDelegate {

    private Expression methodName;

    @Override
    public void execute(DelegateExecution execution) {
        String name = execution.getCurrentActivityName();
        String processBusinessKey = execution.getProcessBusinessKey();
        String id = execution.getId();
        LogBack.info(id + "---" + name + "---" + processBusinessKey);
        try {
            LogBack.info(name + "开始执行！");
            String taskmethodName = (String) methodName.getValue(execution);
            if (StringUtils.isNotNull(taskmethodName)) {
                String url = Config.get("springproject.acproductexturl") + taskmethodName;
                LogBack.info("url:" + url);
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
                MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
                params.add("supApplyId", processBusinessKey);
                HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
                String strbody = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
                LogBack.info("返回信息strbody = " + strbody);
                JSONObject json = JSONObject.parseObject(strbody);
                if (json.containsKey("acstatus")) {
                    execution.setVariable("acstatus", json.getString("acstatus"));
                } else {
                    execution.setVariable("acstatus", "不通过");
                }
                LogBack.info(name + "serviceTask已经执行完毕！");
            } else {
                execution.setVariable("acstatus", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
