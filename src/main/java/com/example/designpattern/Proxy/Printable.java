package com.example.designpattern.Proxy;
/**
 * 主体，是代理角色与被代理角色之间具有一致性的接口
 * @author 尹伟丞
 *
 */
public interface Printable {

	void setPrinterName(String name);
	String getPrinterName();
	void print(String string);
}
