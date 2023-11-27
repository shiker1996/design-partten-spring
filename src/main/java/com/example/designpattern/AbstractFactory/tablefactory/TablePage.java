package com.example.designpattern.AbstractFactory.tablefactory;

import com.example.designpattern.AbstractFactory.factory.Item;
import com.example.designpattern.AbstractFactory.factory.Page;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class TablePage extends Page {

	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><head><title>"+title+"</title></head>\n");
		buffer.append("<body>\n");
		buffer.append("<h1>"+title+"</h1>\n");
		buffer.append("<table width=\"80%\" border = \"3\">\n");
		Iterator<Item> it = content.iterator();
		while(it.hasNext()){
			Item item = (Item)it.next();
			buffer.append("<tr>"+item.makeHTML()+"</tr>");
		}
		buffer.append("</table>\n");
		buffer.append("<hr><address>"+author+"</address>");
		buffer.append("</body></html>\n");
		return buffer.toString();
	}

}
