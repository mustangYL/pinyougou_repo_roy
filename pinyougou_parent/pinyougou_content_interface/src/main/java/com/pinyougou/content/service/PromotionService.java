package com.pinyougou.content.service;

import java.util.List;

import com.pinyougou.pojo.TbPromotion;

public interface PromotionService {

	List<TbPromotion> findPromotionListByStatus();

	void updatePromotionStatus(TbPromotion promotion);

	void deletePromotionById(Long id);



}
