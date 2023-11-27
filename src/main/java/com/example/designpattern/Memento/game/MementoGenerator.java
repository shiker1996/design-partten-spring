package com.example.designpattern.Memento.game;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class MementoGenerator {

	@Lookup
	public abstract Memento memento();

	public Memento genMemento(int money){
		Memento memento = memento();
		memento.initMemento(money);
		return memento;
	}
}
