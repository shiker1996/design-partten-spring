package com.example.designpattern.AbstractFactory.listfactory;

import com.example.designpattern.AbstractFactory.factory.Factory;
import com.example.designpattern.AbstractFactory.factory.FactoryName;
import com.example.designpattern.AbstractFactory.factory.Link;
import com.example.designpattern.AbstractFactory.factory.Page;
import com.example.designpattern.AbstractFactory.factory.Tray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 表示具体工厂，继承抽象工厂
 * @author shiker96
 *
 */
@Service
@FactoryName("listFactory")
public class ListFactory extends Factory {

	@Resource
	private ListGenerator listGenerator;

	@Override
	public Link createLink(String caption, String url) {
		// TODO Auto-generated method stub
		ListLink listLink = listGenerator.listLink();
		listLink.build(caption, url);
		return listLink;
	}

	@Override
	public Tray createTray(String caption) {
		// TODO Auto-generated method stub
		ListTray listTray = listGenerator.listTray();
		listTray.build(caption);
		return listTray;
	}

	@Override
	public Page createPage(String title, String author) {
		// TODO Auto-generated method stub
		ListPage listPage = listGenerator.listPage();
		listPage.build(title, author);
		return listPage;
	}

}
