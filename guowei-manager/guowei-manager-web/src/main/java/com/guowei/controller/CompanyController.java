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
import com.guowei.pojo.GwCompany;
import com.guowei.service.CompanyService;

/**
 * @描述：公司Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class CompanyController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private CompanyService companyService;
	
	/**
	 * 查询公司记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/company/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwCompany company) {
		DatatablesView dataTable = companyService.getGwCompanysByPagedParam(company,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/companys")
	public String toList(HttpServletRequest request){   
		return "company";
	}
	
	/**
	 * 公司添加
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/company/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwCompany company = new GwCompany();
		if (!"".equals(request.getParameter("mid"))) {
			company.setMid(Long.parseLong(request.getParameter("mid")));
		}
		if (!"".equals(request.getParameter("templateId"))) {
			company.setTemplateId(Long.parseLong(request.getParameter("templateId")));
		}
		if (!"".equals(request.getParameter("companyName"))) {
			company.setCompanyName(request.getParameter("companyName"));
		}
		if (!"".equals(request.getParameter("companyAddr"))) {
			company.setCompanyAddr(request.getParameter("companyAddr"));		
		}
		if (!"".equals(request.getParameter("companyContactname"))) {
			company.setCompanyContactname(request.getParameter("companyContactname"));
		}
		if (!"".equals(request.getParameter("companyContactposition"))) {
			company.setCompanyContactposition(request.getParameter("companyContactposition"));
		}
		if (!"".equals(request.getParameter("companyContactphone"))) {
			company.setCompanyContactphone(request.getParameter("companyContactphone"));
		}
		if (!"".equals(request.getParameter("companyContactwechat"))) {
			company.setCompanyContactwechat(request.getParameter("companyContactwechat"));
		}
		if (!"".equals(request.getParameter("companyContactwechatopenid"))) {
			company.setCompanyContactwechatopenid(request.getParameter("companyContactwechatopenid"));
		}
		if (!"".equals(request.getParameter("did"))) {
			company.setDid(Long.parseLong(request.getParameter("did")));
		}
		company.setCreated(Calendar.getInstance().getTime());
		company.setPurchased(Calendar.getInstance().getTime());
		int result = companyService.addGwCompany(company);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "公司： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 公司修改
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/company/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		GwCompany company = companyService.getGwCompanyById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("mid"))) {
			company.setMid(Long.parseLong(request.getParameter("mid")));
		}
		if (!"".equals(request.getParameter("templateId"))) {
			company.setTemplateId(Long.parseLong(request.getParameter("templateId")));
		}
		if (!"".equals(request.getParameter("companyName"))) {
			company.setCompanyName(request.getParameter("companyName"));
		}
		if (!"".equals(request.getParameter("companyAddr"))) {
			company.setCompanyName(request.getParameter("companyAddr"));		
		}
		if (!"".equals(request.getParameter("companyContactname"))) {
			company.setCompanyName(request.getParameter("companyContactname"));
		}
		if (!"".equals(request.getParameter("companyContactposition"))) {
			company.setCompanyName(request.getParameter("companyContactposition"));
		}
		if (!"".equals(request.getParameter("companyContactphone"))) {
			company.setCompanyName(request.getParameter("companyContactphone"));
		}
		if (!"".equals(request.getParameter("companyContactwechat"))) {
			company.setCompanyName(request.getParameter("companyContactwechat"));
		}
		if (!"".equals(request.getParameter("did"))) {
			company.setDid(Long.parseLong(request.getParameter("did")));
		}
		int status = companyService.editGwCompany(company);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "公司：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 公司删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/company/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = companyService.removeGwCompany(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}