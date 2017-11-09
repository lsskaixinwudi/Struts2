package com.situ.struts.interceptor;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class InterceptorAction extends ActionSupport{
	public String register(){
		System.out.println("InterceptorAction.execute()");
		return SUCCESS;
	}
}
