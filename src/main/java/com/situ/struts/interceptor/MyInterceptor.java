package com.situ.struts.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class MyInterceptor implements Interceptor {
    public MyInterceptor() {
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
       System.out.println("2. 拦截器，业务处理-开始");
       // 调用下一个拦截器或执行Action (相当于chain.doFilter(..)
       // 获取的是： execute方法的返回值
       String resultFlag = invocation.invoke();
       System.out.println("4. 拦截器，业务处理-结束");
       return resultFlag;
    }
}

