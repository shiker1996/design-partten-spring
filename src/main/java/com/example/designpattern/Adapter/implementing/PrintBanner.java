package com.example.designpattern.Adapter.implementing;

import com.example.designpattern.Adapter.Banner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 适配器角色
 * @author shiker96
 *
 */
@Component
public class PrintBanner implements Print{

	//通过创建目标对象获取目标对象的功能
	@Resource
	private Banner banner;

	public void setString(String string){
		banner.setString(string);
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		banner.showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		banner.showWithAster();
	}
}
