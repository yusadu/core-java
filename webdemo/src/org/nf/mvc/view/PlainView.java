package org.nf.mvc.view;

import javax.servlet.ServletException;
import java.io.IOException;

public class PlainView extends AbstractView{

    private String content;

    public PlainView(String content){
        this.content=content;
    }

    @Override
    public void response() throws IOException, ServletException {
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().println(content);
    }
}
