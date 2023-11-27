package com.example.designpattern.Memento;

import com.example.designpattern.Memento.game.Gamer;
import com.example.designpattern.Memento.game.Memento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class MementoController {

	@Resource
	private Gamer gamer;

	@GetMapping("/memento")
	public String memento(){
		gamer.setMoney(1000);
		Memento memento = gamer.createMemento();
		for(int i=0;i<100;i++){
			log.info("==== "+i);
			log.info("当前状态："+gamer);
			gamer.bet();
			log.info("所持金钱为"+gamer.getMoney()+"元");
			if(gamer.getMoney()>memento.getMoney()){
				log.info("(所持金钱增加了许多，因此保持游戏当前的状态）");
				memento= gamer.createMemento();
			}else if(gamer.getMoney()<memento.getMoney()/2){
				log.info("(所持金钱减少了许多，因此将游戏恢复至以前的状态）");
				gamer.restoreMemento(memento);
			}
		}
		return gamer.toString();
	}
}
