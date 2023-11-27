package com.example.designpattern.Visitor;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class VisitorGenerator {

	@Lookup
	protected abstract VDirectory directory();

	@Lookup
	protected abstract VFile file();

	public VDirectory genDirectory(String name){
		VDirectory directory = directory();
		directory.initDirectory(name);
		return directory;
	}

	public VFile genFile(String name, int size){
		VFile VFile = file();
		VFile.initFile(name, size);
		return VFile;
	}
}
