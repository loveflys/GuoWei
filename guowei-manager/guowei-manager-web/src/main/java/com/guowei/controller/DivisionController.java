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
import com.guowei.pojo.GwDivision;
import com.guowei.service.DivisionService;

/**
 * @描述：地址Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class DivisionController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private DivisionService divisionService;
	
	/**
	 * 查询地址记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/division/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwDivision division) {
		DatatablesView dataTable = divisionService.getGwDivisionsByPagedParam(division,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/divisions")
	public String toList(HttpServletRequest request){   
		return "division";
	}
	
	/**
	 * 地址添加
	 * @param division
	 * @param model
	 * @return
	 */
	@RequestMapping("/division/add")
	public String add(GwDivision division, ModelMap model) {
		int result = divisionService.addGwDivision(division);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "地址： 添加成功!");
		}
		return "register";
	}
	
	/**
	 * 地址修改
	 * @param division
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/division/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		GwDivision division = divisionService.getGwDivisionById(Long.parseLong(request.getParameter("id")));
//		division.setPhone(request.getParameter("phone"));
		int status = divisionService.editGwDivision(division);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "地址：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 地址删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/division/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = divisionService.removeGwDivision(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}