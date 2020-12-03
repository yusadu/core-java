package org.nf.mvc.param;

import org.nf.mvc.param.impl.ParamsResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象的参数解析器
 * 封装请求和相应对象，让子类继承
 * 继承接口的抽象方法，让不同的子类去实现
 */
public abstract class AbsoubltParamResolver implements ParamsResolver {

    protected HttpServletResponse response;
    protected HttpServletRequest request;

    public void setResponse(HttpServletResponse response){
        this.response=response;
    }

    public void setRequest(HttpServletRequest request){
        this.request=request;
    }
}
