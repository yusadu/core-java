package org.nf.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 抽象视图
 * 对应的子类实现可能有转发视图、重定向视图
 * 或者是JSON字符串
 */
public abstract class AbstractView{
    protected HttpServletResponse response;
    protected HttpServletRequest request;

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public abstract void response() throws IOException, ServletException;
}
