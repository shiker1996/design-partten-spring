package com.example.designpattern.Flyweight;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.HashMap;
/**
 * 轻量级工厂：生成共享角色的工厂
 * @author shiker96
 *
 */
@Component
public abstract class BigCharFactory {

	private HashMap<String, BigChar> pool = new HashMap<String, BigChar>();

	@Lookup
	public abstract BigChar bigChar();

	public BigChar genBigChar(char charName){
		BigChar bigChar = bigChar();
		bigChar.initBigChar(charName);
		return bigChar;
	}

    /**
     * 类似与spring中beanfactory的创建
     * @param charname
     * @return
     */
    public synchronized BigChar getBigChar(char charname){
    	BigChar bc = pool.get(""+charname);
    	if(bc==null){
    		bc = genBigChar(charname);
    		pool.put(""+charname, bc);
    	}
    	return bc;
    }
}
