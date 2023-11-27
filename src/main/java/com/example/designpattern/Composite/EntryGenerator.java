package com.example.designpattern.Composite;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class EntryGenerator {

	@Lookup
	public abstract Directory directory();

	public Directory generateDir(String name){
		Directory directory = directory();
		directory.initDirectory(name);
		return directory;
	}

	@Lookup
	public abstract File file();

	public File generateFile(String name, int size){
		File file = file();
		file.initEntry(name, size);
		return file;
	}
}
