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
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwSupplier;
import com.guowei.pojo.GwSupplierstorage;
import com.guowei.service.SupplierService;
import com.guowei.service.SupplierstorageService;

/**
 * @描述：供应商Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2017-9-16 16:13:43
 */
@Controller
public class SupplierController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private SupplierService supplierService;
	
	@Resource
	private SupplierstorageService supplierstorageService;
	
	/**
	 * 查询供应商记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/supplier/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwSupplier supplier) {
		DatatablesView dataTable = supplierService.getGwSuppliersByPagedParam(supplier,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询供应商记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/supplier/getComplateData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getComplateData(HttpServletRequest request, GwSupplier supplier) {
		DatatablesView dataTable = supplierService.getGwSuppliersByPagedParam(supplier,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
//		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询供应商记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/supplier/getAllData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getAllData(HttpServletRequest request, GwSupplier supplier) {
		supplier.setSupplierName("");
		DatatablesView dataTable = supplierService.getGwSuppliersByParam(supplier);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping(value="/supplier/getbyid", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request) {
		GwSupplier dataTable = supplierService.getGwSupplierById(Long.parseLong(request.getParameter("id")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询供应商货架记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/supplier/getStorageData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getProData(HttpServletRequest request) {
		GwSupplierstorage temp = new GwSupplierstorage();
		temp.setSid(Long.parseLong(request.getParameter("id")));	
		DatatablesView dataTable = supplierstorageService.getGwSupplierstoragesByParam(temp);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/suppliers")
	public ModelAndView toList(HttpServletRequest request){   
		ModelAndView model = new ModelAndView("suppliers");
		model.addObject("currentUser", request.getSession().getAttribute(Constants.CURRENT_USER));
		return model;
	}
	
	/**
	 * 供应商添加
	 * @param supplier
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwSupplier supplier = new GwSupplier();
		if (!"".equals(request.getParameter("mid"))) {
			supplier.setMid(Long.parseLong(request.getParameter("mid")));
		}
		if (!"".equals(request.getParameter("supplierName"))) {
			supplier.setSupplierName(request.getParameter("supplierName"));
		}
		if (!"".equals(request.getParameter("supplierAddr"))) {
			supplier.setSupplierAddr(request.getParameter("supplierAddr"));		
		}
		if (!"".equals(request.getParameter("supplierContactname"))) {
			supplier.setSupplierContactname(request.getParameter("supplierContactname"));
		}
		if (!"".equals(request.getParameter("supplierContactposition"))) {
			supplier.setSupplierContactposition(request.getParameter("supplierContactposition"));
		}
		if (!"".equals(request.getParameter("supplierContactphone"))) {
			supplier.setSupplierContactphone(request.getParameter("supplierContactphone"));
		}
		if (!"".equals(request.getParameter("supplierContactwechat"))) {
			supplier.setSupplierContactwechat(request.getParameter("supplierContactwechat"));
		}
		supplier.setCreated(Calendar.getInstance().getTime());
		int result = supplierService.addGwSupplier(supplier);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "供应商： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 供应商货架添加
	 * @param supplier
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/addStorage", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String addStorage(HttpServletRequest request, ModelMap model) {
		GwSupplierstorage supplierstorage = new GwSupplierstorage();
		if (!"".equals(request.getParameter("sid"))) {
			supplierstorage.setSid(Long.parseLong(request.getParameter("sid")));
		}
		if (!"".equals(request.getParameter("supplierName"))) {
			supplierstorage.setStorageName(request.getParameter("storageName"));
		}
		supplierstorage.setCreated(Calendar.getInstance().getTime());
		int result = supplierstorageService.addGwSupplierstorage(supplierstorage);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "供应商货架： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 供应商货架修改
	 * @param supplier
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/updateStorage", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String updateStorage(HttpServletRequest request, ModelMap model) {
		Long storageId = Long.parseLong(request.getParameter("storageId"));
		GwSupplierstorage supplierstorage = supplierstorageService.getGwSupplierstorageById(storageId);
		if (!"".equals(request.getParameter("supplierName"))) {
			supplierstorage.setStorageName(request.getParameter("storageName"));
		}
		int result = supplierstorageService.editGwSupplierstorage(supplierstorage);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "供应商货架： 修改成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 供应商货架删除
	 * @param supplier
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/delStorage", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delStorage(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		int result = supplierstorageService.removeGwSupplierstorage(id);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "供应商货架： 删除成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 供应商修改
	 * @param supplier
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		GwSupplier supplier = supplierService.getGwSupplierById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("mid"))) {
			supplier.setMid(Long.parseLong(request.getParameter("mid")));
		}
		if (!"".equals(request.getParameter("supplierName"))) {
			supplier.setSupplierName(request.getParameter("supplierName"));
		}
		if (!"".equals(request.getParameter("supplierAddr"))) {
			supplier.setSupplierAddr(request.getParameter("supplierAddr"));		
		}
		if (!"".equals(request.getParameter("supplierContactname"))) {
			supplier.setSupplierContactname(request.getParameter("supplierContactname"));
		}
		if (!"".equals(request.getParameter("supplierContactposition"))) {
			supplier.setSupplierContactposition(request.getParameter("supplierContactposition"));
		}
		if (!"".equals(request.getParameter("supplierContactphone"))) {
			supplier.setSupplierContactphone(request.getParameter("supplierContactphone"));
		}
		if (!"".equals(request.getParameter("supplierContactwechat"))) {
			supplier.setSupplierContactwechat(request.getParameter("supplierContactwechat"));
		}
		int status = supplierService.editGwSupplier(supplier);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "供应商：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	

	
	/**
	 * 供应商删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = supplierService.removeGwSupplier(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}