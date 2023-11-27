package com.example.designpattern.Facade;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
/**
 * 从邮件地址中获取用户名的类
 * @author shiker96
 *
 */
public class Database {

	public static Properties getProperties(String dbname){
		String filename = dbname + ".txt";
		Properties prop =  new Properties();
		try{
			File file = ResourceUtils.getFile("classpath:templates/"+ filename);
			prop.load(Files.newInputStream(Paths.get(file.getPath())));
		}catch(IOException e){
			System.out.println("Warning: "+filename+" is not found");
		}
		return prop;
	}
}
