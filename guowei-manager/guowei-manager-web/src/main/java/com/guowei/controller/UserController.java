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
import com.guowei.common.pojo.Constant;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.common.utils.PayUtils;
import com.guowei.pojo.GwApply;
import com.guowei.pojo.GwCompany;
import com.guowei.pojo.GwComplain;
import com.guowei.pojo.GwManager;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwUser;
import com.guowei.service.CompanyService;
import com.guowei.service.UserService;

/**
 * @描述：用户Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间：：2016-11-21 下午11:08:43
 */
@Controller
public class UserController {
	
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private UserService userService;
	
	/**
	 * 用户登陆
	 * @param request
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/sign")
	public ModelAndView sign(HttpServletRequest request, GwUser user, Model model){   
		user = userService.getGwUserByNamePassword(user);
		if(user != null){
			request.getSession().setAttribute(Constants.CURRENT_USER, user);
			return new ModelAndView("redirect:/users");
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
	@RequestMapping(value="/user/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwUser user) {
		DatatablesView dataTable = userService.getGwUsersByPagedParam(user,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询投诉记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/getComplains", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getComplains(HttpServletRequest request, GwComplain complain) {
		GwComplain temp = new GwComplain();
		temp.setContactPhone(request.getParameter("name"));
		DatatablesView dataTable = userService.getGwComplainsByPagedParam(temp,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	/**
	 * 查询申请记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user/getApplys", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getApplys(HttpServletRequest request, GwApply apply) {
		GwApply temp = new GwApply();
		temp.setContactPhone(request.getParameter("name"));
		DatatablesView dataTable = userService.getGwApplysByPagedParam(temp,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping(value="/user/apply/getDetail", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getApplyDetail(HttpServletRequest request, Long id) {
		GwApply apply = userService.getGwApplyById(id);
		String data = JSON.toJSONString(apply);
		return data;
	}
	
	@RequestMapping(value="/user/complain/getDetail", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getComplainDetail(HttpServletRequest request, Long id) {
		GwComplain complain = userService.getGwComplainById(id);
		String data = JSON.toJSONString(complain);
		return data;
	}
	
	/**
	 * 申请记录添加
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/apply/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String applyadd(HttpServletRequest request, ModelMap model) {
		GwApply apply = new GwApply();
		if (!"".equals(request.getParameter("uid"))) {
			apply.setUid(Long.parseLong(request.getParameter("uid")));
		}
		if (!"".equals(request.getParameter("companyName"))) {
			apply.setCompanyName(request.getParameter("companyName"));
		}
		if (!"".equals(request.getParameter("companyAddr"))) {
			apply.setCompanyAddr(request.getParameter("companyAddr"));
		}
		if (!"".equals(request.getParameter("contactName"))) {
			apply.setContactName(request.getParameter("contactName"));
		}
		if (!"".equals(request.getParameter("contactPhone"))) {
			apply.setContactPhone(request.getParameter("contactPhone"));
		}
		apply.setCreated(Calendar.getInstance().getTime());
		int result = userService.addGwApply(apply);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "申请记录： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 投诉箱添加
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/complain/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String complainadd(HttpServletRequest request, ModelMap model) {
		GwComplain complain = new GwComplain();
		if (!"".equals(request.getParameter("uid"))) {
			complain.setUid(Long.parseLong(request.getParameter("uid")));
		}
		if (!"".equals(request.getParameter("content"))) {
			complain.setContent(request.getParameter("content"));
		}
		if (!"".equals(request.getParameter("contactPhone"))) {
			complain.setContactPhone(request.getParameter("contactPhone"));
		}
		complain.setCreated(Calendar.getInstance().getTime());
		int result = userService.addGwComplain(complain);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "投诉箱： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/applys")
	public ModelAndView toapplys(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		Object temp = request.getSession().getAttribute(Constants.CURRENT_USER);
		JSONObject json = JSON.parseObject(JSON.toJSONString(temp));
		String level = json.getString("level");
		if (level != null && !"".equals(level)) {
			if ("3".equals(level)) {
				return new ModelAndView("applys");
			}
		} else {
			return new ModelAndView("applys");
		}
	
		return model;
	}
	
	@RequestMapping("/complains")
	public ModelAndView tocomplains(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("index");
		Object temp = request.getSession().getAttribute(Constants.CURRENT_USER);
		JSONObject json = JSON.parseObject(JSON.toJSONString(temp));
		String level = json.getString("level");
		if (level != null && !"".equals(level)) {
			if ("3".equals(level)) {
				return new ModelAndView("complains");
			}
		} else {
			return new ModelAndView("complains");
		}
	
		return model;
	}
	
	
	
	@RequestMapping("/apply")
	public ModelAndView toapply(HttpServletRequest request) {
		return new ModelAndView("apply");
	}
	
	@RequestMapping("/complain")
	public ModelAndView tocomplain(HttpServletRequest request) {
		return new ModelAndView("complain");
	}
	
	
	
	@RequestMapping("/users")
	public ModelAndView toList(HttpServletRequest request){   
		ModelAndView model = new ModelAndView("index");
		GwManager manager = (GwManager) request.getSession().getAttribute(Constants.CURRENT_USER);
		model.addObject("currentUser", manager);
		if (manager.getLevel() == Byte.parseByte("3")) {
			return new ModelAndView("user");
		}
		return model;
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/out")
	public String out(HttpServletRequest request){   
		request.getSession().setAttribute("user", null);
		return "login";
	}
	
	/**
	 * 用户找回密码
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/resetPassword/service")
	public String forgetPassword(HttpServletRequest request){   
		request.getSession().setAttribute("user", null);
		return "login";
	}
	
	/**
	 * 用户注册用户名验证
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/reusername", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String reUsername(String username) {
		GwUser user = userService.getGwUserByName(username);
		String result;
		if (user != null) {
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
	@RequestMapping("/user/reg")
	public String register(){ 
		return "register";
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/add")
	public String add(GwUser user, ModelMap model) {
		int result = userService.addGwUser(user);
		if (result == 1) {
			model.addAttribute("result", result);
			model.addAttribute("msg", user.getName() + " 注册成功!");
			log.info(Constants.SYS_NAME + "用户：" + user.getName() + " 注册成功!");
		}
		return "register";
	}
	
	/**
	 * 用户修改
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/user/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		System.out.println(request.getParameter("id"));
		GwUser user = userService.getGwUserById(Long.parseLong(request.getParameter("id")));
		user.setPhone(request.getParameter("phone"));
		int status = userService.editGwUser(user);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "用户：" + user.getName() + " 修改成功!");
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
	@RequestMapping(value = "/user/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = userService.removeGwUser(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
}