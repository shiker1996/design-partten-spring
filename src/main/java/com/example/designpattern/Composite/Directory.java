package com.example.designpattern.Composite;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Slf4j
public class Directory extends Entry{
    private String name;
    private ArrayList<Entry> directory = new ArrayList<Entry>();

	public void initDirectory(String name) {
		this.name = name;
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
		Iterator<Entry> it = directory.iterator();
		while(it.hasNext()){
			Entry entry = it.next();
			size+=entry.getSize();
		}
		return size;
	}
    public Entry add(Entry entry){
    	directory.add(entry);
    	return this;
    }
	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		log.info(prefix+"/"+this);
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry object = (Entry) it.next();
			object.printList(prefix+"/"+name);
		}
	}

}
