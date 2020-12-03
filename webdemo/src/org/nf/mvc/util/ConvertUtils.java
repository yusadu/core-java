package org.nf.mvc.util;

public class ConvertUtils {

    /**
     * 基本数据类型转换
     * @param requestParam
     * @param clazz
     * @return
     */
    public static Object convert(String requestParam, Class<?> clazz){
        if(requestParam == null){
            return null;
        }
        Object value=null;
        if(clazz.equals(String.class)){
            value=requestParam;
        }else if (clazz.equals(Integer.TYPE) || clazz.equals(Integer.class)){
            value=Integer.valueOf(requestParam);
        }else if (clazz.equals(Short.class)||clazz.equals(Short.TYPE)){
            value=Short.valueOf(requestParam);
        }else if(clazz.equals(Long.class)||clazz.equals(Long.TYPE)){
            value=Long.valueOf(requestParam);
        }else if (clazz.equals(Boolean.class)||clazz.equals(Boolean.TYPE)){
            value=Boolean.valueOf(requestParam);
        }else if(clazz.equals(Character.class)||clazz.equals(Character.TYPE)){
            value=Character.valueOf(requestParam.charAt(0));
        }else if (clazz.equals(Float.class)||clazz.equals(Float.TYPE)){
            value=Float.valueOf(requestParam);
        }else if (clazz.equals(Double.class)||clazz.equals(Double.TYPE)){
            value=Double.valueOf(requestParam);
        }else if(clazz.equals(Byte.class) || clazz.equals(Byte.TYPE)){
            value=Byte.valueOf(requestParam);
        }
        return value;
    }
}
