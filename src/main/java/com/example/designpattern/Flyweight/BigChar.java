package com.example.designpattern.Flyweight;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * 轻量级角色：表示会被共享的实例
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Slf4j
public class BigChar {

	private char charname;
	private String fontdata;

	public void initBigChar(char charname){
		this.charname = charname;
		try{
			File file = ResourceUtils.getFile("classpath:static/big"+charname+".txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			StringBuffer buf = new StringBuffer();
			while((line=reader.readLine())!=null){
				buf.append(line);
				buf.append("\n");
			}
			reader.close();
			this.fontdata = buf.toString();
		}catch(IOException e){
			this.fontdata = charname+"?";
		}
		
	}

	public void print(){
		log.info(fontdata);
	}
}
