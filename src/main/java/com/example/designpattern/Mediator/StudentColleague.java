package com.example.designpattern.Mediator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentColleague implements Colleague {

	private Mediator mediator;

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	public void send(String message) {
		this.mediator.sendChanged(message, this);
	}

	@Override
	public String receiveMsg(String msg) {
		log.info("学生收到消息：" + msg);
		return msg;
	}
}