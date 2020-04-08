package com.springactiviti.domain.entity;

import java.io.Serializable;

/**
 * (ActHiActinst)实体类
 *
 * @author makejava
 * @since 2020-04-08 20:46:19
 */
public class ActHiActinst implements Serializable {
    private static final long serialVersionUID = -39533207651623391L;
    
    private String id_;
    
    private String procDefId_;
    
    private String procInstId_;
    
    private String executionId_;
    
    private String actId_;
    
    private String taskId_;
    
    private String callProcInstId_;
    
    private String actName_;
    
    private String actType_;
    
    private String assignee_;
    
    private Object startTime_;
    
    private Object endTime_;
    
    private Long duration_;
    
    private String tenantId_;


    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getProcDefId_() {
        return procDefId_;
    }

    public void setProcDefId_(String procDefId_) {
        this.procDefId_ = procDefId_;
    }

    public String getProcInstId_() {
        return procInstId_;
    }

    public void setProcInstId_(String procInstId_) {
        this.procInstId_ = procInstId_;
    }

    public String getExecutionId_() {
        return executionId_;
    }

    public void setExecutionId_(String executionId_) {
        this.executionId_ = executionId_;
    }

    public String getActId_() {
        return actId_;
    }

    public void setActId_(String actId_) {
        this.actId_ = actId_;
    }

    public String getTaskId_() {
        return taskId_;
    }

    public void setTaskId_(String taskId_) {
        this.taskId_ = taskId_;
    }

    public String getCallProcInstId_() {
        return callProcInstId_;
    }

    public void setCallProcInstId_(String callProcInstId_) {
        this.callProcInstId_ = callProcInstId_;
    }

    public String getActName_() {
        return actName_;
    }

    public void setActName_(String actName_) {
        this.actName_ = actName_;
    }

    public String getActType_() {
        return actType_;
    }

    public void setActType_(String actType_) {
        this.actType_ = actType_;
    }

    public String getAssignee_() {
        return assignee_;
    }

    public void setAssignee_(String assignee_) {
        this.assignee_ = assignee_;
    }

    public Object getStartTime_() {
        return startTime_;
    }

    public void setStartTime_(Object startTime_) {
        this.startTime_ = startTime_;
    }

    public Object getEndTime_() {
        return endTime_;
    }

    public void setEndTime_(Object endTime_) {
        this.endTime_ = endTime_;
    }

    public Long getDuration_() {
        return duration_;
    }

    public void setDuration_(Long duration_) {
        this.duration_ = duration_;
    }

    public String getTenantId_() {
        return tenantId_;
    }

    public void setTenantId_(String tenantId_) {
        this.tenantId_ = tenantId_;
    }

}