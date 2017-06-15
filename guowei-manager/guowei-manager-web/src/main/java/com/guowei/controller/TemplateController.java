package com.guowei.controller;

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
import com.guowei.pojo.GwTemplate;
import com.guowei.pojo.GwTemplateproduct;
import com.guowei.service.ProductService;
import com.guowei.service.TemplateService;
import com.guowei.service.TemplateproductService;

/**
 * @描述：模板Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class TemplateController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private TemplateService templateService;
	
	@Resource
	private ProductService productService;
	
	@Resource
	private TemplateproductService templateproductService;
	
	/**
	 * 查询模板记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/template/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwTemplate template) {
		DatatablesView dataTable = templateService.getGwTemplatesByPagedParam(template,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询模板商品记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/template/getProData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getProData(HttpServletRequest request) {
		GwTemplateproduct temp = new GwTemplateproduct();
		temp.setTid(Long.parseLong(request.getParameter("tid")));
		if (request.getParameter("status") == null || request.getParameter("status").equals("")) {
			//默认查询status为1的商品
			temp.setStatus(Byte.parseByte("1"));
		} else if (!"0".equals(request.getParameter("status"))) {
			temp.setStatus(Byte.parseByte(request.getParameter("status")));
		}
		
		DatatablesView dataTable = templateproductService.getGwTemplateproductsByParam(temp);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/templates")
	public String toList(HttpServletRequest request){   
		return "template";
	}
	
	/**
	 * 模板添加
	 * @param template
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/template/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwTemplate template = new GwTemplate();
		if (!"".equals(request.getParameter("name"))) {
			template.setName(request.getParameter("name"));
		}
		template.setCreated(Calendar.getInstance().getTime());
		template.setUpdated(Calendar.getInstance().getTime());
		int result = templateService.addGwTemplate(template);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "模板： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 模板商品添加
	 * @param template
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/template/addProData", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String addProData(HttpServletRequest request, ModelMap model) {
		GwTemplateproduct template = new GwTemplateproduct();
		template.setTid(Long.parseLong(request.getParameter("tid")));
		template.setPid(Long.parseLong(request.getParameter("pid")));
		
		DatatablesView res = templateproductService.getGwTemplateproductsByParam(template);
		
		if (res.getRecordsTotal() > 0) {
			
			GwTemplateproduct temppro = (GwTemplateproduct) res.getData().get(0);
			temppro.setStatus(Byte.parseByte("1"));
			temppro.setUpdated(Calendar.getInstance().getTime());
			
			int result = templateproductService.editGwTemplateproduct(temppro);
			if (result == 1) {		
				model.addAttribute("result", result);
				log.info(Constants.SYS_NAME + "模板商品： 添加成功!");
			}
			MessageView msg = new MessageView(result);
			return JSON.toJSONString(msg);
			
		} else {
		
			GwProduct pro = productService.getGwProductById(Long.parseLong(request.getParameter("pid")));
			
			template.setSellprice(pro.getPrice());
			template.setStock(10);
			template.setStorageracks(Byte.parseByte(request.getParameter("huojia")));
			template.setStatus(Byte.parseByte("1"));
			template.setCreated(Calendar.getInstance().getTime());
			template.setUpdated(Calendar.getInstance().getTime());
			int result = templateproductService.addGwTemplateproduct(template);
			if (result == 1) {		
				model.addAttribute("result", result);
				log.info(Constants.SYS_NAME + "模板商品： 添加成功!");
			}
			MessageView msg = new MessageView(result);
			return JSON.toJSONString(msg);
		}
	}
	
	/**
	 * 模板商品添加
	 * @param template
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/template/deleteProData", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String deleteProData(HttpServletRequest request, ModelMap model) {
		GwTemplateproduct template = templateproductService.getGwTemplateproductById(Long.parseLong(request.getParameter("id")));
		template.setStatus(Byte.parseByte("2"));
		template.setUpdated(Calendar.getInstance().getTime());
		int result = templateproductService.editGwTemplateproduct(template);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "模板商品： 删除成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 模板修改
	 * @param template
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/template/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		GwTemplate template = templateService.getGwTemplateById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("name"))) {
			template.setName(request.getParameter("name"));
		}
		template.setUpdated(Calendar.getInstance().getTime());
		int status = templateService.editGwTemplate(template);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "模板：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 模板删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/template/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = templateService.removeGwTemplate(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}