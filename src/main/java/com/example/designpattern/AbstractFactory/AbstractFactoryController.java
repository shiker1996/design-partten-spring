package com.example.designpattern.AbstractFactory;

import com.example.designpattern.AbstractFactory.factory.Factory;
import com.example.designpattern.AbstractFactory.factory.Link;
import com.example.designpattern.AbstractFactory.factory.Page;
import com.example.designpattern.AbstractFactory.factory.Tray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class AbstractFactoryController {


	@Resource
	private AbstractFactoryGenerator abstractFactoryGenerator;



	/**
	 * Usage: Java Main class.name.of.ConcreteFactory
	 *
	 * @param factoryName
	 * @return
	 */
	@GetMapping("/createFactoryBean")
	public ModelAndView factory(String factoryName, String author){
		ModelAndView modelAndView = new ModelAndView();
		if(!abstractFactoryGenerator.isSupportFactory(factoryName)){
			modelAndView.addObject("errorMsg", "根据factoryName获取不到对应工厂");
			modelAndView.setViewName("error");
			return modelAndView;
		}
		Factory factory = abstractFactoryGenerator.getFactory(factoryName);
		createPage(factory, author);
		modelAndView.setViewName("hello");
		return modelAndView;
	}


	private void createPage(Factory factory, String author){
		Link people = factory.createLink("人民日报", "http://www.people.com/");
		Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");

		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo  = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.com/");
		Link excite = factory.createLink("Excite", "http://www.excite.com/");
		Link google = factory.createLink("Google", "http://www.google.com/");

		Tray traynews = factory.createTray("日报");
		traynews.add(people);
		traynews.add(gmw);

		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		Tray traysearch = factory.createTray("搜索引擎");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);

		Page page = factory.createPage("hello", author);
		page.add(traynews);
		page.add(traysearch);
		page.output();
	}
}
