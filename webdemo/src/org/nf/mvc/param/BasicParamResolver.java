package org.nf.mvc.param;

import org.nf.mvc.param.AbsoubltParamResolver;
import org.nf.mvc.util.ConvertUtils;

import java.lang.reflect.Parameter;

public class BasicParamResolver  extends AbsoubltParamResolver {
    @Override
    public Object process(Parameter param){
        //参数类型
        Class<?> paramType=param.getType();
        //参数名
        String paramName=param.getName();
        String requestParam=request.getParameter(paramName);
        Object value=null;
        try{
            value= ConvertUtils.convert(requestParam,paramType);
            //返回转换后结果的值
            return  value;
        }catch (Exception e){
            //如果是不支持的类型，则会引发一场
            //返回空，让下一个转换器继续处理
            return null;
        }
    }

}
