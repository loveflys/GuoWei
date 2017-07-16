package com.guowei.controller;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.pojo.SimpleListResult;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwProduct;
import com.guowei.service.ProductService;

/**
 * @描述：商品Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class ProductController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ProductService productService;
	
	/**
	 * 查询商品记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/product/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwProduct product) {
		DatatablesView dataTable = productService.getGwProductsByPagedParam(product,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询商品记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/product/getAllData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getAllData(HttpServletRequest request, GwProduct product) {
		DatatablesView dataTable = productService.getGwProductsByParam(product);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/products")
	public String toList(HttpServletRequest request){   
		return "product";
	}
	
	/**
	 * 商品添加
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/product/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwProduct product = new GwProduct();
		if (!"".equals(request.getParameter("title"))) {
			product.setTitle(request.getParameter("title"));
		}
		if (!"".equals(request.getParameter("image"))) {
			product.setImage(request.getParameter("image"));
		}
		if (!"".equals(request.getParameter("price"))) {
			product.setPrice(new BigDecimal(request.getParameter("price")));
		}
		if (!"".equals(request.getParameter("discountprice"))) {
			product.setDiscountprice(new BigDecimal(request.getParameter("discountprice")));
		}
		if (!"".equals(request.getParameter("buyingprice"))) {
			product.setBuyingprice(new BigDecimal(request.getParameter("buyingprice")));
		}
		if (!"".equals(request.getParameter("stock"))) {
			product.setStock(Integer.parseInt(request.getParameter("stock")));
		}
		if (!"".equals(request.getParameter("distribute"))) {
			product.setDistribute(Integer.parseInt(request.getParameter("distribute")));
		}
		product.setCreated(Calendar.getInstance().getTime());
		product.setUpdated(Calendar.getInstance().getTime());
		if (!"".equals(request.getParameter("allsellcount"))) {
			product.setAllsellcount(0);
		}
		if (!"".equals(request.getParameter("cid"))) {
			product.setCid(Long.parseLong(request.getParameter("cid")));
		}
		if (!"".equals(request.getParameter("status"))) {
			product.setStatus(Byte.parseByte(request.getParameter("status")));		
		}
		int result = productService.addGwProduct(product);
		if (result == 1) {		
			model.addAttribute("result", result);
			model.addAttribute("msg", product.getTitle() + " 添加成功!");
			log.info(Constants.SYS_NAME + "商品：" + product.getTitle() + " 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 商品修改
	 * @param product
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/product/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		GwProduct product = productService.getGwProductById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("title"))) {
			product.setTitle(request.getParameter("title"));
		}
		if (!"".equals(request.getParameter("image"))) {
			product.setImage(request.getParameter("image"));
		}
		if (!"".equals(request.getParameter("price"))) {
			product.setPrice(new BigDecimal(request.getParameter("price")));
		}
		if (!"".equals(request.getParameter("discountprice"))) {
			product.setDiscountprice(new BigDecimal(request.getParameter("discountprice")));
		}
		if (!"".equals(request.getParameter("buyingprice"))) {
			product.setBuyingprice(new BigDecimal(request.getParameter("buyingprice")));
		}
		if (!"".equals(request.getParameter("stock"))) {
			product.setStock(Integer.parseInt(request.getParameter("stock")));
		}
		if (!"".equals(request.getParameter("distribute"))) {
			product.setDistribute(Integer.parseInt(request.getParameter("distribute")));
		}
		product.setUpdated(Calendar.getInstance().getTime());
		if (!"".equals(request.getParameter("allsellcount"))) {
			product.setAllsellcount(Integer.parseInt(request.getParameter("allsellcount")));
		}
		if (!"".equals(request.getParameter("cid"))) {
			product.setCid(Long.parseLong(request.getParameter("cid")));
		}
		if (!"".equals(request.getParameter("status"))) {
			product.setStatus(Byte.parseByte(request.getParameter("status")));		
		}
		int status = productService.editGwProduct(product);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "商品：" + product.getTitle() + " 修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 商品删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/product/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = productService.removeGwProduct(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}