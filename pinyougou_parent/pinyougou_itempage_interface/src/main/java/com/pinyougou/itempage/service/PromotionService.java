package com.pinyougou.itempage.service;

import java.util.List;

import com.pinyougou.pojo.TbPromotion;

public interface PromotionService {

	TbPromotion findPromotionById(Long promotionsId);

	List<TbPromotion> findAllPromotions();

}
