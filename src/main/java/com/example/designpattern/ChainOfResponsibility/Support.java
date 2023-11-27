package com.example.designpattern.ChainOfResponsibility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Support {

	private String name;
	private Support next;

	public Support setNext(Support next) {
		this.next = next;
		return next;
	}

	protected void setName(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return "Support [name=" + name + "]";
	}

	public final void support(Trouble trouble) {
		if (resolve(trouble)) {
			done(trouble);
		} else if (next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}

	protected void fail(Trouble trouble) {
		// TODO Auto-generated method stub
		log.info(trouble + "cannot be resolved. ");
	}

	protected void done(Trouble trouble) {
		// TODO Auto-generated method stub
		log.info(trouble + "is resolved by " + this + ".");
	}

	protected abstract boolean resolve(Trouble trouble);
}
