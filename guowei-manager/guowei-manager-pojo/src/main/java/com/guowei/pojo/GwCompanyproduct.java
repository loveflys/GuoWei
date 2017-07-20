package com.guowei.pojo;

import java.math.BigDecimal;

public class GwCompanyproduct {
    private Long id;

    private Long companyId;

    private Long pid;

    private Integer stock;

    private Integer warnstock;

    private Integer sellcount;

    private BigDecimal sellprice;

    private Byte storageracks;

    private Byte status;

    private String proname;

    private String proimage;

    private BigDecimal proprice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Integer getSellcount() {
        return sellcount;
    }

    public void setSellcount(Integer sellcount) {
        this.sellcount = sellcount;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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