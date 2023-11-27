package com.example.designpattern.AbstractFactory.tablefactory;

import com.example.designpattern.AbstractFactory.factory.Factory;
import com.example.designpattern.AbstractFactory.factory.FactoryName;
import com.example.designpattern.AbstractFactory.factory.Link;
import com.example.designpattern.AbstractFactory.factory.Page;
import com.example.designpattern.AbstractFactory.factory.Tray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@FactoryName("tableFactory")
public class TableFactory extends Factory {

	@Resource
	private TableGenerator tableGenerator;
	
	@Override
	public Link createLink(String caption, String url) {
		// TODO Auto-generated method stub
		TableLink tableLink = tableGenerator.tableLink();
		tableLink.build(caption, url);
		return tableLink;
	}

	@Override
	public Tray createTray(String caption) {
		// TODO Auto-generated method stub
		TableTray tableTray = tableGenerator.tableTray();
		tableTray.build(caption);
		return tableTray;
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO Auto-generated method stub
		TablePage tablePage = tableGenerator.tablePage();
		tablePage.build(title, author);
		return tablePage;
	}

}
