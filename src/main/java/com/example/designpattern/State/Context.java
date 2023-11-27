package com.example.designpattern.State;
/**
 * 状况、前后关系、上下文
 * @author shiker96
 *
 */
public interface Context {
	void setClock(int hour);
	void changeState(State state);
	void callSecurityCenter(String msg);
	void recordLog(String msg);
}
