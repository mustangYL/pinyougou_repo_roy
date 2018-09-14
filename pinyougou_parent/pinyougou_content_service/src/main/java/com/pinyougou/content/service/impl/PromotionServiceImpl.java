package com.pinyougou.content.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.content.service.PromotionService;
import com.pinyougou.mapper.TbPromotionMapper;
import com.pinyougou.pojo.TbPromotion;
import com.pinyougou.pojo.TbPromotionExample;
import com.pinyougou.pojo.TbPromotionExample.Criteria;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	private TbPromotionMapper promotionMapper;

	@Override
	public List<TbPromotion> findPromotionListByStatus() {
		TbPromotionExample example = new TbPromotionExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusNotEqualTo("2");
		List<TbPromotion> list = promotionMapper.selectByExample(example );
		return list;
	}

	@Override
	public void updatePromotionStatus(TbPromotion promotion) {
		promotion.setStatus("1");
		promotionMapper.updateByPrimaryKey(promotion);
		
	}

	@Override
	public void deletePromotionById(Long id) {
		promotionMapper.deleteByPrimaryKey(id);
		
	}

	

	
	


}
