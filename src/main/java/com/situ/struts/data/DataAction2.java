package com.situ.struts.data;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DataAction2 extends ActionSupport implements RequestAware, SessionAware, ApplicationAware {
    private Map<String, Object> request;
    private Map<String, Object> session;
    private Map<String, Object> application;
    // struts运行时候，会把代表request的map对象注入
    @Override
    public String execute() throws Exception {
       request.put("request_data3", "request_data3");
        session.put("session_data3", "session_data3");
        application.put("application_data3", "application_data3");
       return SUCCESS;
    }
    // struts运行时候，会把代表application的map对象注入
    @Override
    public void setApplication(Map<String, Object> application) {
       this.application = application;
    }
    // struts运行时候，会把代表session的map对象注入
    @Override
    public void setSession(Map<String, Object> session) {
       this.session = session;
    }
    // struts运行时候，会把代表request的map对象注入
    @Override
    public void setRequest(Map<String, Object> request) {
       this.request = request;
    }
}
