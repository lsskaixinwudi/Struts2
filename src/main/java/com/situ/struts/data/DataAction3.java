package com.situ.struts.data;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DataAction3 extends ActionSupport{
    ActionContext ac;
    public DataAction3() {
       ac = ActionContext.getContext();
    }
}

