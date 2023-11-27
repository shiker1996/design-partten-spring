package com.example.designpattern.Strategy;

public class Hand {

	public static final int HANDVALUE_GUU = 0;
	public static final int HANDVALUE_CHO = 1;
	public static final int HANDVALUE_PAA = 2;
    public static final Hand[] hand = {
    	new Hand(HANDVALUE_GUU),
    	new Hand(HANDVALUE_CHO),
    	new Hand(HANDVALUE_PAA),
    };
    private static final String[] name ={
    	"石头","剪刀","步",
    };
    private int handvalue;
	public Hand(int handvalue) {
		super();
		this.handvalue = handvalue;
	}
	public static Hand getHand(int handvalue){
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h){
		return fight(h) == 1;
	}
	private int fight(Hand h) {
		// TODO Auto-generated method stub
		if(this==h){
			return 0;
		}else if((this.handvalue+1)%3==h.handvalue){
			return 1;
		}else{
			return -1;
		}
	}
	public String toString(){
		return name[handvalue];
	}
}
