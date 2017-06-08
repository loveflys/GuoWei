package com.guowei.controller;

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
import com.guowei.pojo.GwCategory;
import com.guowei.service.CategoryService;

/**
 * @描述：分类Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class CategoryController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 查询分类记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/category/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwCategory category) {
		DatatablesView dataTable = categoryService.getGwCategorysByPagedParam(category,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/categorys")
	public String toList(HttpServletRequest request){   
		return "category";
	}
	
	/**
	 * 分类添加
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping("/category/add")
	public String add(GwCategory category, ModelMap model) {
		int result = categoryService.addGwCategory(category);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "分类： 添加成功!");
		}
		return "register";
	}
	
	/**
	 * 分类修改
	 * @param category
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/category/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		GwCategory category = categoryService.getGwCategoryById(Long.parseLong(request.getParameter("id")));
//		category.setPhone(request.getParameter("phone"));
		int status = categoryService.editGwCategory(category);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "分类：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 分类删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/category/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = categoryService.removeGwCategory(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}