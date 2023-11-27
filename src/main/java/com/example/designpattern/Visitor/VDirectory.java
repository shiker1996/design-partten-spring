package com.example.designpattern.Visitor;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 表示文件夹的类
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VDirectory extends Entry {

	private String name;
	private ArrayList<Entry> dir = new ArrayList<Entry>();
	
	public void initDirectory(String name) {
		this.name = name;
	}
   
	public Entry add(Entry entry){
		dir.add(entry);
		return this;
	}
	
	public Iterator<Entry> iterator(){
		return dir.iterator();
	}
	
	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
        v.visit(this);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		int size = 0;
		Iterator<Entry> it = dir.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();
			size+=entry.getSize();
		}
		return size;
	}

}
