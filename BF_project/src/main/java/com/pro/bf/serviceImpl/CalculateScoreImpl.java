package com.pro.bf.serviceImpl;

import com.pro.bf.service.CalculateScore;

public class CalculateScoreImpl implements CalculateScore {

	@Override
	public float calcScore(String kind, float score){
		
		float salesAccount = 0;
		if(kind.equals("chicken")){
			salesAccount += score*60*15000*3/100;
			//salesAccount += 15000*3;
		}else if(kind.equals("cafe")){
			salesAccount += score*4500*65*3/100;
		}else if(kind.equals("restaurant")){
			salesAccount += score*400000*3/100;
		}else if(kind.equals("pension")){
			
		}
		return salesAccount;
	}
}
