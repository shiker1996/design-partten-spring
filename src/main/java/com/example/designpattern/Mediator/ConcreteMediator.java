package com.example.designpattern.Mediator;

import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ConcreteMediator extends Mediator {
	@Setter
	private TeacherColleague teacherColleague;
	@Setter
	private StudentColleague studentColleague;

	@Override
	public String sendChanged(String message, Colleague colleague) {
		if (colleague == teacherColleague) {
			return teacherColleague.receiveMsg(message);
		} else {
			return studentColleague.receiveMsg(message);
		}
	}
}