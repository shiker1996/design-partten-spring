package com.example.designpattern.Adapter.extending;

import com.example.designpattern.Adapter.Banner;

/**
 * 适配器角色
 * @author shiker96
 *
 */
//@Component
public class PrintBanner extends Banner implements Print{

	@Override
	public void setString(String string) {
		super.setString(string);
	}

	@Override
	public void printWeak() {
		// TODO Auto-generated method stub
		showWithParen();
	}

	@Override
	public void printStrong() {
		// TODO Auto-generated method stub
		showWithAster();
	}

}
