package edu.nf.ch02;

import java.io.IOException;
import java.util.Properties;

public class PropUtils {
    public static String getProperty(String key)throws IOException{
        Properties prop=null;
        try{
            prop=new Properties();
        }catch (Exception e){
            e.printStackTrace();
        }
        String className=prop.getProperty("name");
        return className;
    }
}
