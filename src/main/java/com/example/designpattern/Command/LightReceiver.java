package com.example.designpattern.Command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LightReceiver {
	private boolean status;

	public void on() {
		status = true;
		log.info("电灯打开了。状态为{}", true);
	}

	public void off() {
		status = false;
		log.info("电灯关闭了。状态为{}", false);
	}

	public void undo(){
		status = !status;
		log.info("上一条指令撤销！状态为{}", status);
	}

	public boolean isStatus() {
		return status;
	}
}
