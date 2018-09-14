package com.pinyougou.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pinyougou.mapper.TbPromotionMapper;
import com.pinyougou.pojo.TbPromotion;
import com.pinyougou.pojo.TbPromotionExample;

@Component
public class PromotionTask {
	
	@Autowired
	private TbPromotionMapper promotionMapper;

	@Scheduled(cron="0 35 19 13 9 ?")
	public void deletePromotion() throws Exception {
		while(true) {
			TbPromotionExample exampleOnsell = new TbPromotionExample();
			exampleOnsell .createCriteria()
			.andEndDateGreaterThanOrEqualTo(new Date())  //结束时间 > 当前时间
			.andStartDateLessThanOrEqualTo(new Date());  //开始时间 < 当前时间
			List<TbPromotion> onsellPrommotionlist = promotionMapper.selectByExample(exampleOnsell );
			for (TbPromotion onsellPrommotion : onsellPrommotionlist) {
				onsellPrommotion.setStatus("1");
				promotionMapper.updateByPrimaryKey(onsellPrommotion);
			}
			
			TbPromotionExample exampleOutime = new TbPromotionExample();
			exampleOutime.createCriteria()
			.andEndDateLessThanOrEqualTo(new Date()); //结束时间 <当前时间
			List<TbPromotion> outPrommotionlist = promotionMapper.selectByExample(exampleOutime );
			for (TbPromotion outPrommotion : outPrommotionlist) {
				outPrommotion.setStatus("2");
				promotionMapper.updateByPrimaryKey(outPrommotion);
			}
			
			TbPromotionExample exampleOnTheWay = new TbPromotionExample();
			exampleOnTheWay.createCriteria()
			.andStartDateGreaterThan(new Date());
			List<TbPromotion> onTheWayPrommotionlist = promotionMapper.selectByExample(exampleOnTheWay );
			for (TbPromotion onTheWayPromotion : onTheWayPrommotionlist) {
				onTheWayPromotion.setStatus("0");
				promotionMapper.updateByPrimaryKey(onTheWayPromotion);
			}
			
			
			
			
			
			Thread.sleep(1000);
		}
	}
}
