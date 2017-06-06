package com.guowei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author 陈安一
 *
 */
@Controller
public class PageController {
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex () {		
		return "login";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
}
