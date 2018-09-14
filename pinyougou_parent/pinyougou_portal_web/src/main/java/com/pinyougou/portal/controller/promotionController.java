package com.pinyougou.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.content.service.PromotionService;
import com.pinyougou.pojo.TbContent;
import com.pinyougou.pojo.TbPromotion;

@RestController
@RequestMapping("/promotion")
public class promotionController {

	@Reference
	private PromotionService promotionService;
	
	
	
	@RequestMapping("/findPromotionListByStatus")
	public List<TbPromotion> findPromotionListByStatus( ){
		List<TbPromotion> list = promotionService.findPromotionListByStatus();
		return list;
	}
	
	@RequestMapping("/updatePromotionStatus")
	public void updatePromotionStatus(@RequestBody TbPromotion promotion) {
		promotionService.updatePromotionStatus(promotion);
	}
	
	@RequestMapping("/deletePromotionById/{id}")
	public void deletePromotionById(@PathVariable("id") Long id) {
		promotionService.deletePromotionById(id);
	}
	
}
