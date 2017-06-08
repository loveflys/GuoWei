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
import com.guowei.pojo.GwUser;
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
	
	@RequestMapping("/users")
	public String toList(HttpServletRequest request){   
		return "user";
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