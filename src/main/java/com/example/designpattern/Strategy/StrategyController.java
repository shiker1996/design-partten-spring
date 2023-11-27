package com.example.designpattern.Strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StrategyController {

	@Resource
	private StrategyGenerator strategyGenerator;

	@GetMapping("strategy")
	private String strategy(Integer seed1, Integer seed2){
		if (seed1 == null || seed2 == null) {
			log.info("Useage: java Main randomseed1 randomseed2");
			log.info("Example: java Main 314 15");
			return "ERROR";
		}
		Player player1 = strategyGenerator.genPlayer("Trao", StrategyEnum.WINNING_STRATEGY, seed1);
		Player player2 =strategyGenerator.genPlayer("Hana", StrategyEnum.RANDOM_STRATEGY, seed2);
		for (int i = 0; i < 10; i++) {
			Hand nextHand1 = player1.nextHand();
			Hand nextHand2 = player2.nextHand();
			if (nextHand1.isStrongerThan(nextHand2)) {
				log.info("Winner:" + player1);
				player1.win();
				player2.lose();
			} else if (nextHand2.isStrongerThan(nextHand1)) {
				log.info("WInner:" + player2);
				player1.lose();
				player2.win();
			} else {
				log.info("Even....");
				player1.even();
				player2.even();
			}
		}
		log.info("Total result:");
		log.info(player1.toString());
		log.info(player2.toString());
		return "SUCCESS";
	}
}
