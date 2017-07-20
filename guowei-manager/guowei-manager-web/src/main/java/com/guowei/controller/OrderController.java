package com.guowei.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.pojo.SimpleListResult;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderdetail;
import com.guowei.service.OrderService;

/**
 * @描述：订单Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class OrderController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private OrderService orderService;
	
	/**
	 * 查询订单记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/order/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwOrder order) {
		DatatablesView dataTable = orderService.getGwOrdersByPagedParam(order,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/orders")
	public String toList(HttpServletRequest request){   
		return "order";
	}
	
	/**
	 * 订单添加
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/order/submit", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		String details = request.getParameter("details");
		JSONArray proList=JSON.parseArray(details);
		Long companyId = Long.parseLong(request.getParameter("companyId"));
		String companyName = request.getParameter("companyName");
		Long uid = Long.parseLong(request.getParameter("uid"));
		String uname = request.getParameter("uname");
		Date now = Calendar.getInstance().getTime();
		if (request.getParameter("companyId") == null || "".equals(request.getParameter("companyId"))) {
			model.addAttribute("result", "公司编号有误，请联系系统管理员解决。");
			return "";
		}
		if (request.getParameter("companyName") == null || "".equals(request.getParameter("companyName"))) {
			model.addAttribute("result", "公司名称有误，请联系系统管理员解决。");
			return "";
		}
		if (request.getParameter("details") == null || "".equals(request.getParameter("details"))) {
			model.addAttribute("result", "购物车产品有误，请联系系统管理员解决。");
			return "";
		}
		if (proList == null || proList.size() <= 0) {
			model.addAttribute("result", "请先选择商品");
			return "";
		}
		if (request.getParameter("uid") == null || "".equals(request.getParameter("uid"))) {
			model.addAttribute("result", "用户信息有误，请联系系统管理员解决。");
			return "";
		}
		if (request.getParameter("uname") == null || "".equals(request.getParameter("uname"))) {
			model.addAttribute("result", "用户信息有误，请联系系统管理员解决。");
			return "";
		}
		GwOrder order = new GwOrder();
		List<GwOrderdetail> orderdetails = new ArrayList<GwOrderdetail>();
		
		BigDecimal amount = new BigDecimal("0");
		for (int i = 0, length = proList.size(); i < length; i++) {
			JSONObject temp = proList.getJSONObject(i);
			GwOrderdetail orderdetail = new GwOrderdetail();
			int number = temp.getInteger("number");
			int stock = temp.getInteger("stock");
			if (number > stock) {
				return "库存不足";
			}
			orderdetail.setCompanyId(companyId);
			orderdetail.setCompanyName(companyName);
			orderdetail.setCpid(temp.getLong("id"));
			orderdetail.setCreated(now);
			orderdetail.setNumber(number);
			orderdetail.setPimg(temp.getString("proimage"));
			orderdetail.setPname(temp.getString("proname"));
			orderdetail.setPrice(temp.getBigDecimal("proprice"));
			amount = amount.add(temp.getBigDecimal("proprice").multiply(new BigDecimal(temp.getBigInteger("number"))));
			orderdetail.setUid(uid);
			orderdetail.setUserName(uname);
			orderdetails.add(orderdetail);
		}
		
		
//		order.set
		order.setCompanyId(companyId);
		order.setCompanyName(companyName);
		order.setUid(uid);
		order.setUname(uname);
		order.setStatus(Byte.parseByte("1"));
		order.setCreated(now);
		order.setAmount(amount);
		int result = 0;
		try {
			result = orderService.createGwOrder(order, orderdetails);
		} catch (UnsupportedEncodingException e) {
			
		}
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "订单： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 订单修改
	 * @param order
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/order/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		GwOrder order = orderService.getGwOrderById(Long.parseLong(request.getParameter("id")));
//		order.setPhone(request.getParameter("phone"));
		int status = orderService.editGwOrder(order);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "订单：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping(value = "/order/getdetail", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getdetail(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		Long id = Long.parseLong(request.getParameter("id"));
		DatatablesView dataTable = orderService.getGwOrderDetailsByParam(id);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 订单删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/order/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = orderService.removeGwOrder(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}