package org.nf.mvc.view;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 重定向
 */
public class RedirectView extends AbstractView{

    private String url;

    public RedirectView(String url){
        this.url=url;
    }

    @Override
    public void response() throws IOException, ServletException {
        response.sendRedirect(url);
    }
}
