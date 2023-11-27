package com.example.designpattern.State;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
public abstract class StateGenerator {

	@Lookup
	@ConditionalOnMissingBean(DayState.class)
	public abstract DayState dayState();

	@Lookup
	@ConditionalOnMissingBean(DayState.class)
	public abstract NightState nightState();
}
