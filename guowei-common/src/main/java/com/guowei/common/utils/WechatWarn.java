package com.guowei.common.utils;

import java.util.Date;

public class WechatWarn {
	@SuppressWarnings("deprecation")
	public static void Warn(String CompanyName, String ProductName, Integer stock) {
		String time = "";
		Date now = new Date();
		time = now.getYear() + "-" + (now.getMonth()+1) + "-" + now.getDate()
			+ now.getHours() + ":" + now.getMinutes();
		System.out.println(CompanyName + "公司的" + ProductName + "产品库存不足，请及时补充库存，当前仅剩" + stock + "件。 ----" + time);
	}
}
