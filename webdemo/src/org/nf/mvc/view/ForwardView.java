package org.nf.mvc.view;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 请求转发
 */
public class ForwardView extends AbstractView {
    private  String url;

    public  ForwardView(String url){
        this.url=url;
    }

    @Override
    public void response() throws ServletException ,IOException{
        request.getRequestDispatcher(url).forward(request,response);
    }
}
