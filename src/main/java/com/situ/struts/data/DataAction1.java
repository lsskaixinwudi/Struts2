package com.situ.struts.data;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction1 extends ActionSupport{
    @Override
    public String execute() throws Exception {
        System.out.println("DataAction1.execute()");
       HttpServletRequest request1 = ServletActionContext.getRequest();
       HttpSession session1 = request1.getSession();
       ServletContext application1 = ServletActionContext.getServletContext();
        request1.setAttribute("request_data1", "request_data1");
        session1.setAttribute("session_data1", "session_data1");
        application1.setAttribute("application_data1", "application_data1");
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> contextMap = actionContext.getContextMap();
        Map<String, Object> session = actionContext.getSession();
       Map<String, Object> application = actionContext.getApplication();
       contextMap.put("request_data2", "request_data2");
        session.put("session_data2", "session_data2");
        application.put("application_data2", "application_data2");
       
       return SUCCESS;
    }
}

