package com.example.designpattern.Builder.framework;


import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * 使用builder中的方法编写文档内容
 * @author shiker96
 *
 */
@Service
@Setter
public class Director {

	private Builder builder;
	
	public void construct(){
		builder.makeTitle("Greeting");
		builder.makeString("从早上至上午");
		builder.makeItems(new String[]{
				"早上好。",
				"下午好。",
		});
		builder.makeString("晚上");
		builder.makeItems(new String[]{
				"早上好。",
				"晚安。",
				"再见。",
		});
		builder.close();
	}
}
