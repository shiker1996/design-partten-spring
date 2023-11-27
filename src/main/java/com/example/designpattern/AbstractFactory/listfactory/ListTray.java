package com.example.designpattern.AbstractFactory.listfactory;

import com.example.designpattern.AbstractFactory.factory.Item;
import com.example.designpattern.AbstractFactory.factory.Tray;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class ListTray extends Tray {

	@Override
	public String makeHTML() {
		StringBuffer buffer =  new StringBuffer();
		buffer.append("<li>\n");
		buffer.append(caption+"\n");
		buffer.append("<ul>");
		Iterator<Item> it = tray.iterator();
		while(it.hasNext()){
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		return buffer.toString();
	}

}
