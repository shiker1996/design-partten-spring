package com.example.designpattern.Proxy;

/**
 * 代理人：处理请求，只有当自己不能处理时，才会将工作交给实际主体
 * @author shiker96
 *
 */
public class PrinterProxy implements Printable {
	private String name;

	private Printer real;

	public PrinterProxy(String name) {
		super();
		this.name = name;
	}

	@Override
	public void setPrinterName(String name) {
		if(real!=null){
			real.setPrinterName(name);
		}
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void print(String string) {
		realize();
		real.print(string);
	}

	private synchronized void realize() {
		// TODO Auto-generated method stub
		if(real == null){
			real = new Printer(name);
		}
	}

}
