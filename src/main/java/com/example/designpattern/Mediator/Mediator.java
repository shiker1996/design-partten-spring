package com.example.designpattern.Mediator;
/**
 * 定义仲裁者的接口
 * @author shiker96
 *
 */
public abstract class Mediator {
	/**
	 * 定义一个抽象的发送消息方法，得到同事对象和发送信息
	 * @param message
	 * @param colleague
	 */
	public abstract String sendChanged(String message, Colleague colleague);
}