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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwCompanyTemp;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwTemplateproduct;
import com.guowei.pojo.GwUser;
import com.guowei.service.CompanyService;
import com.guowei.service.CompanyproductService;

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
	
	@Resource
	private CompanyproductService companyproductService;
	
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
	
	/**
	 * 查询公司记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/company/getComplateData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getComplateData(HttpServletRequest request, GwCompanyTemp company) {
		DatatablesView dataTable = companyService.getGwCompanyTempsByPagedParam(company,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
//		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping(value="/company/getbyid", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request) {
		GwCompanyTemp dataTable = companyService.selectById(Long.parseLong(request.getParameter("id")));
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
	@RequestMapping(value="/company/getProData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getProData(HttpServletRequest request) {
		GwCompanyproduct temp = new GwCompanyproduct();
		temp.setCompanyId(Long.parseLong(request.getParameter("id")));	
		DatatablesView dataTable = companyproductService.getGwCompanyproductsByParam(temp);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/companys")
	public String toList(HttpServletRequest request){   
		return "companys";
	}
	
	@RequestMapping("/company/{id}")
	public ModelAndView toDetail(HttpServletRequest request, @PathVariable("id") Long id) {
		GwCompany res = companyService.getGwCompanyById(id);
		ModelAndView model = new ModelAndView("company");
		model.addObject("id", id);
		model.addObject("companyName", res.getCompanyName());
		model.addObject("currentUser", request.getSession().getAttribute(Constants.CURRENT_USER));
		return model;
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
	 * 公司模板修改
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/company/changeTemplate", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String changeTemplate(HttpServletRequest request) {
		GwCompany company = companyService.getGwCompanyById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("templateId"))) {
			company.setTemplateId(Long.parseLong(request.getParameter("templateId")));
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