package com.example.designpattern.Proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 实际主体，在代理角色无法胜任工作时出场
 * @author shiker96
 *
 */
@Slf4j
public class Printer implements Printable {

	private String name;

	public Printer(String name) {
		super();
		this.name = name;
		heavyJob("Printer的实例生成中（"+name+"）");
	}

	private void heavyJob(String msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
		for(int i =0;i<5;i++){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
			log.info(".");
		}
		log.info("结束。");
	}

	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}

	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void print(String string) {
		log.info("=== "+name+" ===");
		log.info(string);
	}

}
