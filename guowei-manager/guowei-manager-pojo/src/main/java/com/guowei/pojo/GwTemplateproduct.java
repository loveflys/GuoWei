package com.guowei.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class GwTemplateproduct {
    private Long id;

    private Long pid;

    private Long tid;

    private Integer stock;

    private Integer warnstock;

    private BigDecimal sellprice;

    private Byte storageracks;

    private Date created;

    private Date updated;

    private String proname;

    private String proimage;

    private BigDecimal proprice;

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

    public Integer getWarnstock() {
        return warnstock;
    }

    public void setWarnstock(Integer warnstock) {
        this.warnstock = warnstock;
    }

    public BigDecimal getSellprice() {
        return sellprice;
    }

    public void setSellprice(BigDecimal sellprice) {
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

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getProimage() {
        return proimage;
    }

    public void setProimage(String proimage) {
        this.proimage = proimage;
    }

    public BigDecimal getProprice() {
        return proprice;
    }

    public void setProprice(BigDecimal proprice) {
        this.proprice = proprice;
    }
}