package com.mybatis.mybatis.io;

import java.io.InputStream;
//    使用类加载器读取配置文件
public class Resources {
//    根据传入的参数，获取一个字节流
    public static InputStream getResourceAsStream(String filePath){
        //获取字节码 拿到当前类加载器  根据类加载器读取配置文件
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
