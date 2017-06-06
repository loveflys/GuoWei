package com.guowei.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @描述：DataTables数据封装View
 * @作者：陈安一
 * @版本：V1.0
 */
@SuppressWarnings("serial")
public class DatatablesView<T> implements Serializable{  
	  
    private List<T> data; //data 与datatales 加载的“dataSrc"对应  
    
    private int recordsTotal;   
    
    private int recordsFiltered;  
    
    private int draw;
    
    public DatatablesView() {  
          
    }

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}  
} 