package com.situ.struts.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLoginInterceptor implements Interceptor {
    public CheckLoginInterceptor() {
       System.out.println("创建了拦截器对象");
    }
    @Override
    public void destroy() {
       System.out.println("销毁....");
    }
    @Override
    public void init() {
       System.out.println("执行了拦截器的初始化方法");
    }
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 拿到当前执行的方法名：判断，只有当前方法名不是login,就进行验证
        // 获取ActionContext对象
        ActionContext ac = invocation.getInvocationContext();
        // 获取action的代理对象
        ActionProxy proxy = invocation.getProxy();
        // 获取当前执行的方法名
        String methodName = proxy.getMethod();
        // 判断
        if (!"login".equals(methodName)) {
            // 先获取当前登陆的用户
            Object obj = ac.getSession().get("admin");
            if (obj == null) {
                // 没有登陆
                return "input";
            } 
        } 

        // 说明当前用户正在登陆
        return invocation.invoke();

     }

}

