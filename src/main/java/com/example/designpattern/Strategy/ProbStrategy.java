package com.example.designpattern.Strategy;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@StrategyName(StrategyEnum.PROB_STRATEGY)
public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
    		{1,1,1,},
    		{1,1,1,},
    		{1,1,1,},
    };

    public void setRandom(int seed){
    	random = new Random(seed);
    }
	@Override
	public Hand nextHand() {
		// TODO Auto-generated method stub
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue =  0;
		if(bet<history[currentHandValue][0]){
			handvalue = 0;
		}else if(bet<history[currentHandValue][0]+history[currentHandValue][1]){
			handvalue = 1;
		}else{
			handvalue = 2;
		}
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}

	private int getSum(int hv) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<3;i++){
			sum+=history[hv][i];
		}
		return sum;
	}
	@Override
	public void study(boolean win) {
		// TODO Auto-generated method stub
        if(win){
        	history[prevHandValue][currentHandValue]++;
        }else{
        	history[prevHandValue][(currentHandValue+1)%3]++;
        	history[prevHandValue][(currentHandValue+2)%3]++;
        }
	}

}
