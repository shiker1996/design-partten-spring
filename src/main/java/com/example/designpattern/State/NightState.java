package com.example.designpattern.State;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 具体装态：表示金库夜晚状态
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NightState implements State {

	@Resource
	private StateGenerator stateGenerator;


	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub
        if(9<=hour&&hour<17){
        	context.changeState(stateGenerator.dayState());
        }
	}

	@Override
	public void doUse(Context context) {
		// TODO Auto-generated method stub
        context.callSecurityCenter("紧急：晚上使用金库");
	}

	@Override
	public void doAlarm(Context context) {
		// TODO Auto-generated method stub
        context.callSecurityCenter("按下警铃（晚上）");
	}

	@Override
	public void doPhone(Context context) {
		// TODO Auto-generated method stub
        context.recordLog("晚上的通话录音");
	}

	@Override
	public String toString() {
		return "NightState [晚上]";
	}
	

}
