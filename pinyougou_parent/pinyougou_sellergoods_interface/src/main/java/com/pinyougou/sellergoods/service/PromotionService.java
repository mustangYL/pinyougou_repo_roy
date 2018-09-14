package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbPromotion;

import entity.PageResult;

public interface PromotionService {

	List<TbPromotion> findAll();


	void add(TbPromotion promotion);


	PageResult findPage(int pageNo, int pageSize);


	PageResult findPage(int pageNo, int pageSize, TbPromotion promotion);


	void delete(Long[] ids);


	TbPromotion findOne(Long id);


	void update(TbPromotion promotion);


}
