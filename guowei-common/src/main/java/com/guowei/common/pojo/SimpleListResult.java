package com.guowei.common.pojo;

import java.util.List;

/**
 * 通用列表返回格式
 * @author 陈安一
 *
 */
public class SimpleListResult {
	private long totalCount;
	private List<?> list;
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
}
