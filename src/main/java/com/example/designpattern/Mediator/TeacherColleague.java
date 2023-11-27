package com.example.designpattern.Mediator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TeacherColleague implements Colleague {

	private Mediator mediator;

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public String receiveMsg(String msg) {
		log.info("老师收到消息：" + msg);
		return msg;
	}

	public void send(String message) {
		mediator.sendChanged(message, this);
	}
}
