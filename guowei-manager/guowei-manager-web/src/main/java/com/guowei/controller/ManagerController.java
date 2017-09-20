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
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.pojo.SimpleListResult;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwManager;
import com.guowei.service.ManagerService;

/**
 * @描述：管理员Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class ManagerController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private ManagerService managerService;
	
	/**
	 * 用户登陆
	 * @param request
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping("/managers/sign")
	@ResponseBody
	public ModelAndView sign(HttpServletRequest request, GwManager manager, Model model){   
		manager = managerService.getGwManagerByNamePassword(manager);
		if(manager != null){
			request.getSession().setAttribute(Constants.CURRENT_USER, manager);
			return new ModelAndView("redirect:/managerindex");
		}else{
			model.addAttribute("msg", "登陆失败，请重新登陆!");
			return new ModelAndView("login");
		}
	}
	
	/**
	 * 查询用户记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/managers/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwManager manager) {
		DatatablesView dataTable = managerService.getGwManagersByPagedParam(manager,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping(value="/managers/getAllData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getAllData(HttpServletRequest request, GwManager manager) {
		DatatablesView dataTable = managerService.getGwManagersByParam(manager);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/managerlist")
	public ModelAndView toList(HttpServletRequest request){  
		ModelAndView model = new ModelAndView("index");		
		Object temp = request.getSession().getAttribute(Constants.CURRENT_USER);
		if (temp != null) {
			JSONObject json = JSON.parseObject(JSON.toJSONString(temp));
			String level = json.getString("level");
			if (level != null && !"".equals(level)) {
				if ("3".equals(level)) {
					model = new ModelAndView("manager");
				}
			}
		}
		model.addObject("currentUser", temp);
		return model;
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/managers/out")
	public String out(HttpServletRequest request){   
		request.getSession().setAttribute("manager", null);
		return "login";
	}
	
	/**
	 * 用户找回密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/managers/resetPassword/service")
	public String forgetPassword(HttpServletRequest request){   
		request.getSession().setAttribute("manager", null);
		return "login";
	}
	
	/**
	 * 用户注册用户名验证
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/managers/reusername", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String reUsername(String username) {
		GwManager manager = managerService.getGwManagerByName(username);
		String result;
		if (manager != null) {
			result = "{\"valid\":false}";
		}else{
			result = "{\"valid\":true}";
		}
		return result;
	}
	
	/**
	 * 用户注册
	 * @return
	 */
	@RequestMapping("/managers/reg")
	public String register(){ 
		return "register";
	}
	
	/**
	 * 用户注册
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/managers/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwManager manager = new GwManager();
		if (!"".equals(request.getParameter("area"))) {
			manager.setArea(Long.parseLong(request.getParameter("area")));
		}
		if (!"".equals(request.getParameter("level"))) {
			manager.setLevel(Byte.decode((request.getParameter("level"))));
		}
		if (!"".equals(request.getParameter("sid"))) {
			manager.setSid(Long.parseLong((request.getParameter("sid"))));
		}
		if (!"".equals(request.getParameter("name"))) {
			manager.setName(request.getParameter("name"));
		}
		if (!"".equals(request.getParameter("phone"))) {
			manager.setPhone(request.getParameter("phone"));		
		}
		if (!"".equals(request.getParameter("password"))) {
			manager.setPassword(request.getParameter("password"));
		}
		if (!"".equals(request.getParameter("wechatAccount"))) {
			manager.setWechatAccount(request.getParameter("wechatAccount"));
		}
		manager.setCreated(Calendar.getInstance().getTime());
		int result = managerService.addGwManager(manager);
		if (result == 1) {
			manager = managerService.getGwManagerByNamePassword(manager);
			
			model.addAttribute("result", result);
			model.addAttribute("msg", manager.getName() + " 注册成功!");
			log.info(Constants.SYS_NAME + "用户：" + manager.getName() + " 注册成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 用户修改
	 * @param manager
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/managers/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		GwManager manager = managerService.getGwManagerById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("area"))) {
			manager.setArea(Long.parseLong(request.getParameter("area")));
		}
		if (!"".equals(request.getParameter("level"))) {
			manager.setLevel(Byte.parseByte((request.getParameter("level"))));
		}
		if (!"".equals(request.getParameter("sid"))) {
			manager.setSid(Long.parseLong((request.getParameter("sid"))));
		}
		if (!"".equals(request.getParameter("name"))) {
			manager.setName(request.getParameter("name"));
		}
		if (!"".equals(request.getParameter("phone"))) {
			manager.setPhone(request.getParameter("phone"));		
		}
		if (!"".equals(request.getParameter("password"))) {
			manager.setPassword(request.getParameter("password"));
		}
		if (!"".equals(request.getParameter("wechatAccount"))) {
			manager.setWechatAccount(request.getParameter("wechatAccount"));
		}
		int status = managerService.editGwManager(manager);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "用户：" + manager.getName() + " 修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 用户删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/managers/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = managerService.removeGwManager(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}