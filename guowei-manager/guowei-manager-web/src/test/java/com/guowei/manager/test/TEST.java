package com.guowei.manager.test;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwProduct;
import com.guowei.pojo.GwProductExample;

public class TEST {

	@Test
	public void testPageHelper() {
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从spring容器中获得Mapper的代理对象
		GwProductMapper mapper = applicationContext.getBean(GwProductMapper.class);
		//执行查询，并分页
		GwProductExample example = new GwProductExample();
		//分页处理
		PageHelper.startPage(1, 10);
		List<GwProduct> list = mapper.selectByExample(example);
		//取商品列表
		for (GwProduct GwProduct : list) {
			System.out.println(GwProduct.getTitle());
		}
		//取分页信息
		PageInfo<GwProduct> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品："+ total);
		
	}
}
