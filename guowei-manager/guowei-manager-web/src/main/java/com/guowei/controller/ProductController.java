package com.guowei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guowei.pojo.GwProduct;
import com.guowei.service.ProductService;

/**
 * 商品管理Controller
 * @author 陈安一
 *
 */
@Controller
@RequestMapping("/api/pro")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public GwProduct getProductById (@PathVariable Long id) {
		GwProduct pro = productService.getProductById(id);		
		return pro;		
	}
}
