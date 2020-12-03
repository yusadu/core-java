package org.nf.mvc.param;

import org.nf.mvc.param.AbsoubltParamResolver;
import org.nf.mvc.util.ConvertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class BeanParamResolver extends AbsoubltParamResolver {

    @Override
    public Object process(Parameter param) {
        try{
            Class<?> paramType=param.getType();
            Object obj=paramType.newInstance();
            Field[] fields=paramType.getDeclaredFields();
            for (Field field:fields) {
                //打开访问开关
                field.setAccessible(true);
                //获取字段的类型
                Class<?> fieldType=field.getType();
                //字段名
                String fieldName=field.getName();
                //根据字段名与请求参数的name匹配，获取请求参数的值
                String requestParam=request.getParameter(fieldName);
                Object value= ConvertUtils.convert(requestParam,fieldType);
                field.set(obj,value);
            }
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
