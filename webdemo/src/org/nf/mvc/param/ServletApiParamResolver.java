package org.nf.mvc.param;

import org.nf.mvc.param.AbsoubltParamResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Parameter;

public class ServletApiParamResolver extends AbsoubltParamResolver {

    @Override
    public Object process(Parameter param) {
        Class<?> paramType=param.getType();
        if(paramType.equals(HttpServletResponse.class)){
            return response;
        }else if(paramType.equals(HttpServletRequest.class)){
            return request;
        }else if(paramType.equals(HttpSession.class)){
            return request.getSession();
        }else if(paramType.equals(ServletContext.class)){
            return request.getServletContext();
        }else {
            return null;
        }
    }
}
