package com.guowei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guowei.common.pojo.Constant;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("payURL", Constant.PAY_URL);
		return "index";
	}
}
