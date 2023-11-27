package com.example.designpattern.State;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 具体状态：表示金库晚上的状态
 * @author shiker96
 *
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DayState implements State {

	@Resource
	private StateGenerator stateGenerator;

	@Override
	public void doClock(Context context, int hour) {
		// TODO Auto-generated method stub

		if(hour<9||17<=hour){
			context.changeState(stateGenerator.nightState());
		}
	}

	@Override
	public void doUse(Context context) {
		// TODO Auto-generated method stub
        context.recordLog("使用金库（白天）");
	}

	@Override
	public void doAlarm(Context context) {
		// TODO Auto-generated method stub
        context.callSecurityCenter("按下警铃（白天）");
	}

	@Override
	public void doPhone(Context context) {
		// TODO Auto-generated method stub
        context.callSecurityCenter("正常通话（白天）");
	}

	@Override
	public String toString() {
		return "DayState [白天]";
	}

}
