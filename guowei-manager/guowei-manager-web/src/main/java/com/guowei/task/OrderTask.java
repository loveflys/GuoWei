package com.guowei.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.guowei.mapper.GwOrderMapper;
import com.guowei.pojo.GwOrder;
import com.guowei.pojo.GwOrderExample;
@Component
public class OrderTask {
	@Autowired
	private GwOrderMapper orderMapper;
	
	@Scheduled(cron = "* * 0/1 * * ? ") // 间隔1小时执行
	public void taskCycle() {
		//每小时定时任务=======清理未支付订单，改为已取消状态
		GwOrderExample ex = new GwOrderExample();
		ex.createCriteria().andStatusEqualTo(Byte.parseByte("1"));
		//更改订单状态
		List<GwOrder> orders = orderMapper.selectByExample(ex);
		for (GwOrder order : orders) {
			order.setStatus(Byte.parseByte("4")); //设置订单为已取消
			orderMapper.updateByPrimaryKey(order);
		}
    }
}
