package com.pinyougou.manager.controller;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbPromotion;
import com.pinyougou.sellergoods.service.PromotionService;

import entity.PageResult;
import entity.Result;
import freemarker.template.Configuration;
import freemarker.template.Template;
import util.IdWorker;

@RestController
@RequestMapping("/promotion")
public class PromotionController {
	
	@Autowired
	private IdWorker idWorker;
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Reference
	private PromotionService promotionService;
	
	@RequestMapping("/findAll")
	public List<TbPromotion> findAll(){			
		
		 List<TbPromotion> list = promotionService.findAll();
		 return list;
	}
	
	
	@RequestMapping("search/{pageNo}/{pageSize}")
	public PageResult search(@RequestBody TbPromotion promotion, @PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize) {
//		{total:100,rows:[{},{},{}]}
		PageResult findPage = promotionService.findPage(pageNo,pageSize);
		return findPage;
	}
	
	
	@RequestMapping("findPage/{pageNo}/{pageSize}")
	public PageResult findPage(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize") int pageSize) {
		return promotionService.findPage(pageNo,pageSize);
	}
	
	
	@RequestMapping("/add")
	public Result  add(@RequestBody TbPromotion promotion) {
		try {
			long id = (int)(Math.random() * 1000000);
			promotion.setId(id);
			promotion.setStatus("0");
			promotionService.add(promotion);
			
			//生成静态页面
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("promotion_detail.ftl");
			Map map = new HashMap();
			map.put("promotion", promotion);
			Writer writer = new FileWriter("D:\\pinyougou\\html\\"+promotion.getId()+".html");
			template.process(map, writer);
			writer.close();
			
			
			return new Result(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "保存失败");
		}
	}
	
	@RequestMapping("/update")
	public Result  update(@RequestBody TbPromotion promotion) {
		try {
			promotionService.update(promotion);
			
			//生成静态页面
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("promotion_detail.ftl");
			Map map = new HashMap();
			map.put("promotion", promotion);
			Writer writer = new FileWriter("D:\\pinyougou\\html\\"+promotion.getId()+".html");
			template.process(map, writer);
			writer.close();
			
			
			return new Result(true, "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "保存失败");
		}
	}
	
	@RequestMapping("/delete/{ids}")
	public Result delete(@PathVariable("ids") Long[] ids){
		try {
			promotionService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("/findOne/{id}")
	public TbPromotion findOne(@PathVariable("id") Long id) {
		TbPromotion promotion = promotionService.findOne(id);
		return promotion;
	}
	
}
