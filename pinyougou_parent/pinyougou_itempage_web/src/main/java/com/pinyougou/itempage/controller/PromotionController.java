package com.pinyougou.itempage.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.itempage.service.PromotionService;
import com.pinyougou.pojo.TbPromotion;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Reference
	private PromotionService promotionService;
	
	@RequestMapping("/generatorToHtmlByPromotionsId")
	public String generatorToHtmlByPromotionsId(Long promotionsId) {
		
		try {
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("promotion_detail.ftl");
			Map map = new HashMap();
			
			TbPromotion promotion = promotionService.findPromotionById(promotionsId);
			map.put("promotion", promotion);
		
			Writer writer = new FileWriter("D:\\pinyougou\\html\\"+promotionsId+".html");
			template.process(map, writer);
			writer.close();
			return "success";
		}  catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	@RequestMapping("/generatorToHtmlAll")
	public String generatorToHtmlAll() {
		
		try {
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("promotion_detail.ftl");
			Map map = new HashMap();
			
			
			List<TbPromotion>  promotionsList = promotionService.findAllPromotions();
			for (TbPromotion promotion : promotionsList) {
				map.put("promotion", promotion);
			
				Writer writer = new FileWriter("D:\\pinyougou\\html\\"+promotion.getId()+".html");
				template.process(map, writer);
				writer.close();
			}
			
			return "success";
		}  catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	
}
