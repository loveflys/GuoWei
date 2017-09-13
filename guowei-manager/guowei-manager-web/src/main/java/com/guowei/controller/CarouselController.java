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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.Constants;
import com.guowei.common.utils.MessageView;
import com.guowei.pojo.GwCarousel;
import com.guowei.pojo.GwManager;
import com.guowei.pojo.GwUser;
import com.guowei.service.CarouselService;

/**
 * @描述：轮播图Controller
 * @作者：陈安一
 * @版本：V1.0
 * @创建时间： 2017-09-04 00:15
 */
@Controller
public class CarouselController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private CarouselService carouselService;
	/**
	 * 查询轮播图记录
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/carousel/getData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getData(HttpServletRequest request, GwCarousel carousel) {
		DatatablesView dataTable = carouselService.getGwCarouselsByPagedParam(carousel,Integer.parseInt(request.getParameter("start")),Integer.parseInt(request.getParameter("length")));
		dataTable.setDraw(Integer.parseInt(request.getParameter("draw")));
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping(value="/carousel/getAllData", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String getAllData(HttpServletRequest request,
			@RequestParam(value="type", required = false, defaultValue = "0") String type
			) {
		DatatablesView dataTable = carouselService.getGwCarousels(type);
		String data = JSON.toJSONString(dataTable);
		return data;
	}
	
	@RequestMapping("/carousels")
	public String toList(HttpServletRequest request){   
		GwManager manager = (GwManager) request.getSession().getAttribute(Constants.CURRENT_USER);
		if (manager.getLevel() == Byte.parseByte("3")) {
			return "carousel";
		}
		return "index";
	}
	
	/**
	 * 轮播图添加
	 * @param carousel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/carousel/add", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request, ModelMap model) {
		GwManager manager = (GwManager) request.getSession().getAttribute(Constants.CURRENT_USER);
		GwCarousel carousel = new GwCarousel();
		carousel.setType(Byte.parseByte((request.getParameter("type"))));
		carousel.setTitle(request.getParameter("title"));
		carousel.setPic(request.getParameter("pic"));
		if (!"".equals(request.getParameter("companyId")) && "2".equals(request.getParameter("type"))) {
			carousel.setCompanyId(Long.parseLong(request.getParameter("companyId")));
		}
		carousel.setUid(manager.getId());
		carousel.setCreated(java.util.Calendar.getInstance().getTime());
		
		int result = carouselService.addGwCarousel(carousel);
		if (result == 1) {		
			model.addAttribute("result", result);
			log.info(Constants.SYS_NAME + "轮播图： 添加成功!");
		}
		MessageView msg = new MessageView(result);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 轮播图修改
	 * @param carousel
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/carousel/update", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String update(HttpServletRequest request) {
		GwCarousel carousel = carouselService.getGwCarouselById(Long.parseLong(request.getParameter("id")));
		if (!"".equals(request.getParameter("type"))) {
			carousel.setType(Byte.parseByte(request.getParameter("type")));
		}
		if (!"".equals(request.getParameter("cid")) && "2".equals(request.getParameter("type"))) {
			carousel.setCompanyId(Long.parseLong(request.getParameter("cid")));
		}
		if (!"".equals(request.getParameter("title"))) {
			carousel.setTitle(request.getParameter("title"));
		}
		if (!"".equals(request.getParameter("pic"))) {
			carousel.setPic(request.getParameter("pic"));
		}
		int status = carouselService.editGwCarousel(carousel);
		if (status == 1) {
			log.info(Constants.SYS_NAME + "轮播图：修改成功!");
		}
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
	
	/**
	 * 轮播图删除
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/carousel/del/{id}", method = RequestMethod.DELETE, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		int status = carouselService.removeGwCarousel(id);
		MessageView msg = new MessageView(status);
		return JSON.toJSONString(msg);
	}
}