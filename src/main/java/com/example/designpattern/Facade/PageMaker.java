package com.example.designpattern.Facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.util.Properties;
/**
 * 扮演窗口角色，根据邮件地址编写改用户的web页面
 * @author shiker96
 *
 */
@Component
@Slf4j
public class PageMaker {

	@Resource
	private HtmlWriter writer;

	public void makeWelcomePage(String mailaddr,String filename, String target){
		try{
			Properties mailprop = Database.getProperties(filename);
			String username = mailprop.getProperty(mailaddr);
			File file = ResourceUtils.getFile("classpath:templates/"+ target + ".html");
			writer.setWriter(new FileWriter(file));
			writer.title("Welcome to "+username+"'s page");
			writer.paragraph(username+"欢迎来到"+username+"的主页");
			writer.paragraph("等着你的邮件");
			writer.mailto(mailaddr, username);
			writer.close();
			log.info(target+" is created for "+mailaddr+" ("+username+")");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
