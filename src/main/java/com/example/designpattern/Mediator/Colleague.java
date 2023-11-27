package com.example.designpattern.Mediator;

/**
 * 定义组员的接口
 *
 * @author shiker96
 */
public interface Colleague {

	void setMediator(Mediator mediator);

	String receiveMsg(String msg);

	void send(String msg);
}
