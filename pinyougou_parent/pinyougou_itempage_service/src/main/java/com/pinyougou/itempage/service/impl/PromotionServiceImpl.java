package com.pinyougou.itempage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.itempage.service.PromotionService;
import com.pinyougou.mapper.TbPromotionMapper;
import com.pinyougou.pojo.TbPromotion;

@Service
public class PromotionServiceImpl implements PromotionService {

	@Autowired
	private TbPromotionMapper promotionMapper;
	
	@Override
	public TbPromotion findPromotionById(Long promotionsId) {
		TbPromotion promotion = promotionMapper.selectByPrimaryKey(promotionsId);
		
		
		return promotion;
	}

	@Override
	public List<TbPromotion> findAllPromotions() {
		List<TbPromotion> promotionsList = new ArrayList<TbPromotion>();
		List<TbPromotion> list = promotionMapper.selectByExample(null);
		for (TbPromotion promotion : list) {
			promotion = promotionMapper.selectByPrimaryKey(promotion.getId());
			promotionsList.add(promotion);
		}
		return promotionsList;
	}

}
