package com.example.designpattern.ChainOfResponsibility;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class SupportGenerator {

	@Lookup
	protected abstract NoSupport noSupport();

	@Lookup
	protected abstract OddSupport oddSupport();

	@Lookup
	protected abstract SpecialSupport specialSupport();

	@Lookup
	protected abstract LimitSupport limitSupport();

	public NoSupport genNoSupport(String name){
		NoSupport noSupport = noSupport();
		noSupport.setName(name);
		return noSupport;
	}

	public OddSupport genOddSupport(String name){
		OddSupport oddSupport = oddSupport();
		oddSupport.setName(name);
		return oddSupport;
	}

	public LimitSupport genLimitSupport(String name, int limit){
		LimitSupport limitSupport = limitSupport();
		limitSupport.setLimit(limit);
		limitSupport.setName(name);
		return limitSupport;
	}

	public SpecialSupport genSpecialSupport(String name, int number){
		SpecialSupport specialSupport = specialSupport();
		specialSupport.setName(name);
		specialSupport.setNumber(number);
		return specialSupport;
	}
}


