package com.guowei.pojo;

import java.util.Date;

public class GwTemplateproduct {
    private Long id;

    private Long pid;

    private Long tid;

    private Integer stock;

    private Long sellprice;

    private Byte storageracks;

    private Date created;

    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getSellprice() {
        return sellprice;
    }

    public void setSellprice(Long sellprice) {
        this.sellprice = sellprice;
    }

    public Byte getStorageracks() {
        return storageracks;
    }

    public void setStorageracks(Byte storageracks) {
        this.storageracks = storageracks;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}