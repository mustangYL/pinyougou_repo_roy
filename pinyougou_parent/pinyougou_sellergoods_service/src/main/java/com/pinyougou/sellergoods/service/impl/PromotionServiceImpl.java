package com.pinyougou.sellergoods.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbPromotionMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbPromotion;
import com.pinyougou.pojo.TbPromotionExample;
import com.pinyougou.pojo.TbPromotionExample.Criteria;
import com.pinyougou.sellergoods.service.PromotionService;

import entity.PageResult;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {

	
	
	@Autowired
	private TbPromotionMapper promotionMapper;
	
	@Override
	public List<TbPromotion> findAll() {
		List<TbPromotion> list = promotionMapper.selectByExample(null);
		return list;
	}

	@Override
	public PageResult findPage(int pageNo, int pageSize) {
//		使用pageHelper 分页
		PageHelper.startPage(pageNo, pageSize);
//		使用Page强转结果
		Page<TbPromotion> page = (Page<TbPromotion>) promotionMapper.selectByExample(null);
		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public PageResult findPage(int pageNo, int pageSize, TbPromotion promotion) {
//		使用pageHelper 分页
		PageHelper.startPage(pageNo, pageSize);
		TbPromotionExample example = new TbPromotionExample(); 
		Criteria criteria = example.createCriteria();
//		brand.getFirstChar()
//		if(StringUtils.isNotBlank(promotion.getTitle())) {
//			criteria.andNameLike("%"+promotion.getTitle()+"%");
//		}
//		if(StringUtils.isNotBlank(promotion.getFirstChar())) {
//			criteria.andFirstCharEqualTo(promotion.getFirstChar());
//		}
		//		使用Page强转结果
		Page<TbPromotion> page = (Page<TbPromotion>)promotionMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
	
	
	@Override
	public void add(TbPromotion promotion) {
	
		promotionMapper.insert(promotion);
		
	}
	
	
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			promotionMapper.deleteByPrimaryKey(id);
		}		
	}

	@Override
	public TbPromotion findOne(Long id) {
		TbPromotion promotion = promotionMapper.selectByPrimaryKey(id);
		return promotion;
	}

	@Override
	public void update(TbPromotion promotion) {
		promotionMapper.updateByPrimaryKey(promotion);
		
	}


	

}
