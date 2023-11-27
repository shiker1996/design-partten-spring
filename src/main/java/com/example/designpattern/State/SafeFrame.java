package com.example.designpattern.State;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Objects;

/**
 * 
 * @author shiker96
 *
 */
@Component
@Slf4j
public class SafeFrame implements Context {
	
	private State state;
	@Resource
	private StateGenerator stateGenerator;

	@PostConstruct
	private void init(){
		state = stateGenerator.dayState();
	}

	@Override
	public void setClock(int hour) {
		// TODO Auto-generated method stub
        String clockstring = "现在时间是 ";
        if(hour<10){
        	clockstring += "0"+hour+":00";
        }else{
        	clockstring +=hour+":00";
        }
        log.info(clockstring);
        state.doClock(this, hour);
	}

	@Override
	public void changeState(State state) {
		// TODO Auto-generated method stub
       log.info("从"+this.state+"状态变为了"+state+"状态。");
       this.state = state;
	}

	@Override
	public void callSecurityCenter(String msg) {
		// TODO Auto-generated method stub
        log.info("call!"+msg+"\n");
	}

	@Override
	public void recordLog(String msg) {
		// TODO Auto-generated method stub
		log.info("record..."+msg+"\n");
	}


	public void actionPerformed(String button) {
		// TODO Auto-generated method stub
        log.info(button);
        if(Objects.equals(button, "buttonUse")){
        	state.doUse(this);
        }else if(Objects.equals(button, "buttonAlarm")){
        	state.doAlarm(this);
        }else if(Objects.equals(button, "buttonPhone")){
        	state.doPhone(this);
        }else{
        	log.error("?");
        }
	}

}
