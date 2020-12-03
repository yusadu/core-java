package org.nf.mvc.view;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Gson
 */
public class GsonView extends AbstractView {

    private Object object;

    public GsonView(Object object){
        this.object=object;
    }

    @Override
    public void response() throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        String json=new Gson().toJson(object);
        response.getWriter().println(json);
    }
}
