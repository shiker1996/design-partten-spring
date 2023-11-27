package com.example.designpattern.Builder;

import com.example.designpattern.Builder.framework.Builder;
import com.example.designpattern.Builder.framework.BuilderName;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  使用director的内容生成超文本标记语言
 * @author shiker96
 *
 */
@Component
@BuilderName("htmlBuilder")
public class HTMLBuilder implements Builder {
	private PrintWriter writer;

	private File file;

	@Override
	public void makeTitle(String title) {
		try {
			file = ResourceUtils.getFile("classpath:templates/" + title + ".html");
			writer = new PrintWriter(new FileWriter(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		writer.println("<html><head><title>" + title + "</title></head><body>");
		writer.println("<h1>" + title + "</h1>");
	}

	@Override
	public void makeString(String str) {
		// TODO Auto-generated method stub
		writer.println("<p>"+str+"</p>");
	}

	@Override
	public void makeItems(String[] items) {
		// TODO Auto-generated method stub
        writer.println("<ul>");
        for(int i=0;i<items.length;i++){
        	writer.println("<li>"+items[i]+"</li>");
        }
        writer.println("</ul>");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		writer.println("</body></html>");
		writer.close();
	}
    
	public String getResult(){
		return file.getName();
	}
}
