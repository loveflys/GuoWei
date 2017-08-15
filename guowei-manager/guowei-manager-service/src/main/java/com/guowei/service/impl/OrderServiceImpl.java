package com.guowei.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guowei.common.pojo.DatatablesView;
import com.guowei.common.utils.WechatWarn;
import com.guowei.mapper.GwCompanyproductMapper;
import com.guowei.mapper.GwOrderMapper;
import com.guowei.mapper.GwOrderdetailMapper;
import com.guowei.mapper.GwProductMapper;
import com.guowei.pojo.GwCompanyproduct;
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderExample;
import com.guowei.pojo.GwOrderExample.Criteria;
import com.guowei.pojo.GwOrderdetail;
import com.guowei.pojo.GwOrderdetailExample;
import com.guowei.pojo.GwProduct;
import com.guowei.service.OrderService;
/**
 * 订单管理Service
 * @author 陈安一
 *
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private GwOrderMapper orderMapper;
	@Autowired
	private GwOrderdetailMapper orderdetailMapper;
	@Autowired
	private GwCompanyproductMapper companyproductMapper;
	@Autowired
	private GwProductMapper productMapper;
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public GwOrder getGwOrderById(long parseLong) {
		GwOrder res = orderMapper.selectByPrimaryKey(parseLong);
		return res;
	}
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int addGwOrder(GwOrder order) {
		int res = orderMapper.insert(order);
		return res;
	}
	@Override
	public long createGwOrder(GwOrder order, List<GwOrderdetail> orderdetail) throws UnsupportedEncodingException {
		int res1 = orderMapper.insert(order);
		
		int addDetail = 1;
		if (res1 == 1) {
			for (GwOrderdetail gwOrderdetail : orderdetail) {
				gwOrderdetail.setOid(order.getId());
				addDetail = orderdetailMapper.insert(gwOrderdetail);
			}		
		}
		return (res1==1 && addDetail==1) ? order.getId():0l;
	}
	@Override
	public int updateGwOrderPayStatus(long id) {
		//更改订单状态
		GwOrder order = orderMapper.selectByPrimaryKey(id);
		order.setStatus(Byte.parseByte("2"));
		int updateOrder = orderMapper.updateByPrimaryKey(order);
		
		//扣减库存
		GwOrderdetailExample ex = new GwOrderdetailExample();
		ex.createCriteria().andOidEqualTo(id);
		int updateDetail = 1;
		List<GwOrderdetail> details = orderdetailMapper.selectByExample(ex);
		for (GwOrderdetail gwOrderdetail : details) {
			//获取公司产品明细
			Long cpid = gwOrderdetail.getCpid();
			GwCompanyproduct pro = companyproductMapper.selectByPrimaryKey(cpid);
			int sellcount = pro.getSellcount();
			pro.setSellcount(sellcount + gwOrderdetail.getNumber());
			int stock = pro.getStock();
			int warnstock = pro.getWarnstock();
			if (stock >= gwOrderdetail.getNumber()) {
				pro.setStock(stock - gwOrderdetail.getNumber());
			} else {
				return 0;
			}
			if (pro.getStock() <= warnstock) {
				try {
					WechatWarn.Warn(order.getCompanyName(), pro.getProname(), pro.getStock());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					log.debug("微信库存不足提醒失败==>"+ e.getMessage());
					System.out.println("微信库存不足提醒失败==>"+ e.getMessage());
				}
			}
			Long pid = pro.getPid();				
			GwProduct product = productMapper.selectByPrimaryKey(pid);
			
			int allsellcount = product.getAllsellcount();
			product.setAllsellcount(allsellcount + gwOrderdetail.getNumber());
			int changeStock = 0;
			int changeCPStock = 0;
			changeStock = productMapper.updateByPrimaryKey(product);
			changeCPStock = companyproductMapper.updateByPrimaryKey(pro);
			if (changeStock != 1 || changeCPStock != 1) {
				updateDetail = 0;
			}			
		}
		return (updateOrder == 1 && updateDetail == 1) ? 1:0;
	}
	@Override
	public int editGwOrder(GwOrder order) {
		int res = orderMapper.updateByPrimaryKey(order);
		return res;
	}
	@Override
	public int removeGwOrder(long id) {
		GwOrder order = orderMapper.selectByPrimaryKey(id);
		int removeDetail = 1;
		int res = 0;
		if (order != null) {
			GwOrderdetailExample gme = new GwOrderdetailExample();
			com.guowei.pojo.GwOrderdetailExample.Criteria criteria = gme.createCriteria();
			criteria.andOidEqualTo(id);
			List<GwOrderdetail> orderdetails = orderdetailMapper.selectByExample(gme);
			
			if (orderdetails != null && orderdetails.size() > 0) {
				for (GwOrderdetail temp : orderdetails) {
					int removetemp = orderdetailMapper.deleteByPrimaryKey(temp.getId());
					if (removetemp != 1) {
						removeDetail = 0;
					}
				}
			}
			res = orderMapper.deleteByPrimaryKey(id);
		}
		return (res == 1 && removeDetail ==1) ? 1: 0;
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwOrdersByPagedParam(GwOrder order, Integer start, Integer pageSize) {
		// TODO Auto-generated method stub
		GwOrderExample gme = new GwOrderExample();
		gme.setOrderByClause("created DESC");
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(order.getTitle())) {
//			criteria.andTitleLike(order.getTitle());
//		}		
		int pageNum = (start/pageSize)+1;
		PageHelper.startPage(pageNum, pageSize);
		List<GwOrder> list = orderMapper.selectByExample(gme);
		PageInfo<GwOrder> page = new PageInfo<>(list);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal((int)page.getTotal());
		return result;
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwOrdersByParam(GwOrder order) {
		// TODO Auto-generated method stub
		GwOrderExample gme = new GwOrderExample();
		Criteria criteria = gme.createCriteria();
//		if (!"".equals(order.getTitle())) {
//			criteria.andTitleLike(order.getTitle());
//		}		
		List<GwOrder> list = orderMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public DatatablesView<?> getGwOrderDetailsByParam(Long id) {
		// TODO Auto-generated method stub
		GwOrderdetailExample gme = new GwOrderdetailExample();
		com.guowei.pojo.GwOrderdetailExample.Criteria criteria = gme.createCriteria();
		criteria.andOidEqualTo(id);
		List<GwOrderdetail> list = orderdetailMapper.selectByExample(gme);
		DatatablesView result = new DatatablesView();
		result.setData(list);
		result.setRecordsTotal(list.size());
		return result;
	}
	@Override
	/**
	 * type: 1 - 今日数据 2-本周数据 3-本月数据 4-全部数据
	 */
	public BigDecimal getOrdersData(int type) {
		
		return null;
	}
	
}
