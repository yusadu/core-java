package org.nf.mvc.core;

import org.nf.mvc.param.AbsoubltParamResolver;
import org.nf.mvc.param.impl.ParamsResolver;
import org.nf.mvc.param.BasicParamResolver;
import org.nf.mvc.param.BeanParamResolver;
import org.nf.mvc.param.ServletApiParamResolver;
import org.nf.mvc.view.AbstractView;
import org.nf.mvc.util.ScanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    /**
     * 这个map用户缓存请求的处理方法（Method），
     * key保存是请求的url（也就是Method注解上的URL地址）
     */
    private static Map<String,Method> map = new HashMap<>();

    /**
     * List集合，用户缓存
     */
    private static List<ParamsResolver> resolveList=new ArrayList<>();

    @Override
    public void init() throws ServletException {
        initRequestMapping();
        initParamResolver();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //获取客户端请求的URI地址
        String uri=req.getRequestURI();
        //判断在map集合中是否存在这个key
        //如果存在，则取出对应的Method方法来处理请求
        if (map.containsKey(uri)){
            Method method=map.get(uri);
            try {
                //获取类对象的实例
                Object object=method.getDeclaringClass().newInstance();
                Object[] params=resolverRarams(req,resp,method);
                Object returnView=method.invoke(object,params);
                //判断方法返回值是否为空，如果不为空，则转换
                responseView(returnView,req,resp);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //其他的所有请求都交由Tomcat处理
            //不然就会忽略这些请求导致浏览器空白
            //因此就先获取Tomca的默认Servlet的转发器
           try{
               req.getServletContext().getNamedDispatcher("default").forward(req,resp);
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }

    private void initRequestMapping(){
        //扫描所有包下的类，并返回所有类的反正类名
        List<String> classNames= ScanUtils.scanPackage();
        //循环遍历
        for (String className:classNames) {
            //执行类加载，得到class对象
            Class<?> clazz=null;
            try{
                clazz=Class.forName(className);
                //获取class对象中的所有方法
                Method[] methods=clazz.getMethods();
                //循环遍历方法数组，找出用@WebResult注解的Method
                for (Method method: methods) {
                    if(method.isAnnotationPresent(WebRequest.class)){
                        //获取注解
                        WebRequest anno=method.getAnnotation(WebRequest.class);
                        String url=anno.uri();
                        map.put(url,method);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }


    /**
     * 初始化参数解析器，这些解析器只要初始化一次病缓存起来
     */
    private void initParamResolver(){
        resolveList.add( new BasicParamResolver());
        resolveList.add(new BeanParamResolver());
        resolveList.add(new ServletApiParamResolver());
    }


    /**
     * 解析方法参数
     * @param request
     * @param response
     * @param method
     * @return
     */
    private Object[] resolverRarams(HttpServletRequest request,HttpServletResponse response,Method method){
        //获取请求方法中所有的参数
        Parameter[] parameters=method.getParameters();
        //定义Object数组，用于存放参数的值，长度为参数列表的长度
        Object[] values=new Object[parameters.length];
        //循环遍历参数集合
        for(int i=0;i<parameters.length;i++){
            Parameter param=parameters[i];
            //遍历解析器集合，匹配转换，如果转换成功则返回具体的值
            //否则返回null，让下一个解析器继续处理
            for (ParamsResolver resolver:resolveList) {
                ((AbsoubltParamResolver)resolver).setRequest(request);
                ((AbsoubltParamResolver)resolver).setResponse((response));
                //进行解析转换，并返回转换后的value
                Object value=resolver.process(param);
                //判断value是否为空，不为空则保存到Object数组
                if(value !=null){
                    //将转换后的值保存到Object中
                    values[i]=value;
                    //转换成功就无须再走下一个解析器，直接跳出当前循环
                    //执行下一个参数的转换
                    break;
                }

            }

        }
        return values;
    }

    private void responseView(Object returnView,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        if(returnView!=null){
            //判断如果returnView是View的实例，则可以强转
            if(returnView instanceof AbstractView){
                AbstractView view=(AbstractView)returnView;
                //设置视图响应对象和请求对象
                view.setRequest(request);
                view.setResponse(response);
                //执行视图响应方法
                view.response();
            }else {
                //否则返回的不是AbstractView实例则使用默认视图响应
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println(returnView);
            }
        }
    }

}
