package com.example.designpattern.AbstractFactory.tablefactory;

import com.example.designpattern.AbstractFactory.factory.Item;
import com.example.designpattern.AbstractFactory.factory.Tray;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class TableTray extends Tray {

	@Override
	public String makeHTML() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("<td>");
		buffer.append("<table width=\"100%\" boder=\"1\"><tr>");
		buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""+tray.size()+
				"\"><b>"+caption +"</b></td>");
		buffer.append("</tr>\n");
		buffer.append("<tr>\n");
		Iterator<Item> it = tray.iterator();
		while(it.hasNext()){
			Item item = it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</tr></table>");
		buffer.append("</td>");
		return buffer.toString();
	}

}
