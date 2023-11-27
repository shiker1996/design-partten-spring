package com.example.designpattern.Adapter;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
/**
 * 被适配角色为properties，适配目标为FileIO
 * @author shiker96
 *
 */
public class FileProperties extends Properties implements FileIO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void readFromFile(String filename) throws IOException {
		// TODO Auto-generated method stub
		File file = ResourceUtils.getFile("classpath:templates/"+ filename);
		this.load(Files.newInputStream(file.toPath()));
	}

	@Override
	public void writeToFile(String filename) throws IOException {
		// TODO Auto-generated method stub
		File file = ResourceUtils.getFile("classpath:templates/"+ filename);
		this.store(Files.newOutputStream(file.toPath()), "hello world");
	}

	@Override
	public void setValue(String key, String value) {
		// TODO Auto-generated method stub
		this.setProperty(key, value);
	}

	@Override
	public String getValue(String key) {
		// TODO Auto-generated method stub
		return this.getProperty(key);
	}

}
