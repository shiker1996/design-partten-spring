package com.example.designpattern.Mediator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MediatorController {

	@Resource
	private ConcreteMediator mediator;
	@Resource
	private TeacherColleague teacherColleague;
	@Resource
	private StudentColleague studentColleague;

	@GetMapping("/mediator")
	public String mediator(String item){
		teacherColleague.setMediator(mediator);
		studentColleague.setMediator(mediator);
		mediator.setTeacherColleague(teacherColleague);
		mediator.setStudentColleague(studentColleague);

		teacherColleague.send("早上好啊！");
		studentColleague.send("早安！");
		return mediator.toString();
	}
}
